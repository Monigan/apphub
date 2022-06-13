package ru.apphub.storage.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import ru.apphub.storage.model.FileStorageItem;

public interface FileStorageItemService {

  List<String> IMAGE_MIMETYPES = Arrays.asList("image/jpeg", "image/png", "image/gif");

  FileStorageItem saveFile(MultipartFile multipartFile) throws Exception;

  Collection<FileStorageItem> saveFiles(MultipartFile[] multipartFiles) throws Exception;

  FileStorageItem saveFile(MultipartFile multipartFile, String oldFileName) throws Exception;

  Long getContentLengthByFileName(String folder, String filename) throws Exception;

  /**
   * Строит путь к объекту, сохраненному в объектном хранилище.
   *
   * @param fileStorageItem метаданные файла
   * @return Путь к объекту в хранилище
   */
  Path getFilePath(FileStorageItem fileStorageItem);

  /**
   * Получает объект FileStorageItem из репозитория по его UUID (objectId) или по названию файла
   *
   * @param uuid     UUID запрашиваемого файла. Если пустой, пытаемся извлечь его из названия файла
   * @param request  Реквест, нужный для формирования URI
   * @throws MalformedURLException Если в сигнатуре метода пустые и uuid и fileName
   */
  FileStorageItem findFileStorageItemByUuid(String uuid, HttpServletRequest request)
      throws MalformedURLException;

}
