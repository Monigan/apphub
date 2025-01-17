package ru.apphub.storage.service;

import com.jlefebure.spring.boot.minio.MinioService;
import io.minio.StatObjectResponse;
import java.io.BufferedInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.apphub.storage.configuration.ApplicationProperties;
import ru.apphub.storage.model.FileStorageItem;
import ru.apphub.storage.problem.FileNotFoundProblem;
import ru.apphub.storage.problem.WrongMimeTypeProblem;
import ru.apphub.storage.repository.FileStorageItemRepository;
import ru.apphub.storage.util.GuessType;

@Service
@Transactional
@Slf4j
public class FileStorageItemServiceImpl implements FileStorageItemService {

  private final MinioService minioService;
  private final FileStorageItemRepository fileStorageItemRepository;
  private final GuessType guessType;
  private final ApplicationProperties applicationProperties;

  @Autowired
  public FileStorageItemServiceImpl(MinioService minioService,
                                    FileStorageItemRepository fileStorageItemRepository,
                                    GuessType guessType,
                                    ApplicationProperties applicationProperties) {
    this.minioService = minioService;
    this.fileStorageItemRepository = fileStorageItemRepository;
    this.guessType = guessType;
    this.applicationProperties = applicationProperties;
  }

  @Override
  public FileStorageItem saveFile(MultipartFile multipartFile, String oldFileName)
      throws Exception {
    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
        multipartFile.getInputStream())) {

      FileStorageItem object = new FileStorageItem();

      String originalName = multipartFile.getOriginalFilename();

      String mimeType = guessType.guessMimeType(bufferedInputStream);
      String extension = getExtension(originalName, mimeType).orElse("");
      String fileName = getFileName(object.getObjectId(), extension);
      String url = String.format("%s/%s", fileName, originalName);

      // validate extension against allowed mime-types first
      validateMimeType(extension);

      // upload file to minio and save metadata to database
      String folder = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
      Path path = Paths.get(folder, fileName);
      object.setOldFileStorageName(oldFileName)
          .setFileName(fileName)
          .setExtension(extension)
          .setMimeType(mimeType)
          .setOriginalName(originalName)
          .setUrl(url);
      // загружаем файл в minio
      minioService.upload(path, bufferedInputStream, mimeType);

      // вычисляем размер загруженного файла
      long length = getContentLengthByFileName(folder, fileName);

      object.setLength(length);
      // сохраняем объект
      object = fileStorageItemRepository.save(object);
      return object;
    }
  }

  @Override
  public FileStorageItem saveFile(MultipartFile multipartFile) throws Exception {
    return saveFile(multipartFile, null);
  }

  @Override
  public Collection<FileStorageItem> saveFiles(MultipartFile[] multipartFiles) throws Exception {
    Set<FileStorageItem> fileStorageItems = new HashSet<>(multipartFiles.length);
    for (MultipartFile multipartFile : multipartFiles) {
      fileStorageItems.add(saveFile(multipartFile));
    }
    return fileStorageItems;
  }

  protected void validateMimeType(String extension) {
    if (!applicationProperties.getMimeTypesFilter().getAllowed()
        .contains(StringUtils.lowerCase(extension))) {
      throw new WrongMimeTypeProblem(extension);
    }
  }

  protected String getFileName(UUID uuid, String extension) {
    String filename = uuid.toString();
    if (!extension.equals("")) {
      filename = filename + "." + extension;
    }
    return filename;
  }

  protected Optional<String> getOriginalExtension(String originalName) {
    originalName = originalName.replaceAll("\\s", ""); // удалить все пробельные символы
    String originalExtension = null;
    if (StringUtils.isNotEmpty(originalName)) {
      int index = originalName.lastIndexOf(".");
      if (index <= 0) {
        return Optional.empty();
      }
      originalExtension = originalName.substring(index);
      originalExtension = originalExtension.replace(".", "");
      String regex = "^[a-zA-Z0-9]+$";
      if (!originalExtension.matches(regex)) {
        return Optional.empty();
      }
    }
    return Optional.ofNullable(originalExtension);
  }

  protected Optional<String> getExtension(String originalName, String mimeType) {
    // Если тип из списка IMAGE_MIMETYPES оставляем его
    if (IMAGE_MIMETYPES.contains(StringUtils.lowerCase(mimeType))) {
      return Optional.of(guessType.guessExtension(mimeType));
    }

    String originalOriginalExtension = getOriginalExtension(originalName)
        .orElseGet(() -> guessType.guessExtension(mimeType));

    return Optional.ofNullable(originalOriginalExtension);
  }

  @Override
  public Long getContentLengthByFileName(String folder, String filename) throws Exception {
    StatObjectResponse objectStat = minioService.getMetadata(Paths.get(folder, filename));
    return objectStat.size();
  }

  @Override
  public Path getFilePath(FileStorageItem fileStorageItem) {
    final ZonedDateTime creationDate = fileStorageItem.getCreated();
    final LocalDate localDate =
        LocalDateTime.ofInstant(creationDate.toInstant(), creationDate.getZone()).toLocalDate();

    final String folder = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
    final String fileName = fileStorageItem.getFileName();
    return Paths.get(folder, fileName);
  }

  @Override
  public FileStorageItem findFileStorageItemByUuid(String uuid,
                                                   HttpServletRequest request)
      throws MalformedURLException {
    if (uuid == null) {
      throw new MalformedURLException("There should be uuid in GET /files/ request!");
    }

    final URI type = URI.create(request.getRequestURI());
    final UUID objectId = UUID.fromString(uuid);
    return fileStorageItemRepository.findById(objectId)
        .orElseThrow(() -> new FileNotFoundProblem(objectId, type));

  }

}
