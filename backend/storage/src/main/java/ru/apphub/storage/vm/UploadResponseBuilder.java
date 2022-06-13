package ru.apphub.storage.vm;

import java.net.URI;
import java.util.Optional;
import ru.apphub.storage.model.FileStorageItem;
import ru.apphub.storage.problem.UploadFileProblem;

public class UploadResponseBuilder {
  private FileStorageItem fileItem;
  private URI type;
  UploadResponseBuilder() {
  }

  public UploadResponseBuilder withFileItem(final FileStorageItem fileItem) {
    this.fileItem = fileItem;
    return this;
  }

  public UploadResponseBuilder withType(final URI type) {
    this.type = type;
    return this;
  }

  public UploadResponse build() {
    return Optional.of(fileItem)
        .map(fi -> new UploadResponse(fi.getObjectId(), fi.getOriginalName(), fi.getMimeType()))
        .orElseThrow(() -> new UploadFileProblem(type));
  }
}
