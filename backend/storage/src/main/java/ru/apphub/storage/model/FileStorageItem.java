package ru.apphub.storage.model;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "objects", uniqueConstraints = {
    @UniqueConstraint(name = "uc_objects_object_id", columnNames = {"object_id"}),
    @UniqueConstraint(name = "uc_objects_old_file_storage_name", columnNames = {
        "old_file_storage_name"})
})
@Getter
@Setter
@Accessors(chain = true)
public class FileStorageItem {
  @Id
  @Column(name = "object_id", unique = true, updatable = false, nullable = false)
  private UUID objectId = UUID.randomUUID();

  @Column(name = "old_file_storage_name", unique = true, updatable = false)
  private String oldFileStorageName;

  @Column(name = "url", columnDefinition = "TEXT")
  private String url;

  @Column(name = "file_name", columnDefinition = "TEXT")
  private String fileName;

  @Column(name = "file_type")
  private String fileType;

  @Column(name = "mime_type")
  private String mimeType;

  @Column(name = "extension")
  private String extension;

  @Column(name = "original_name", columnDefinition = "TEXT")
  private String originalName;

  @Column(name = "length")
  private long length;

  @CreationTimestamp
  @Column(name = "created")
  private ZonedDateTime created;

  @UpdateTimestamp
  @Column(name = "updated")
  private ZonedDateTime updated;

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (!(o instanceof FileStorageItem)) {
          return false;
      }
    FileStorageItem token = (FileStorageItem) o;
    return Objects.equals(getObjectId(), token.getObjectId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getObjectId());
  }

  @Override
  public String toString() {
    return "FileStorageItem{" +
        "objectId=" + objectId +
        ", url='" + url + '\'' +
        ", fileName='" + fileName + '\'' +
        ", fileType='" + fileType + '\'' +
        ", mimeType='" + mimeType + '\'' +
        ", extension='" + extension + '\'' +
        ", originalName='" + originalName + '\'' +
        ", length=" + length +
        ", created=" + created +
        ", updated=" + updated +
        '}';
  }
}

