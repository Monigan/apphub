package ru.apphub.storage.model;

import com.google.common.base.MoreObjects;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "thumbnails")
@Getter
@Setter
@Accessors(chain = true)
public class Thumbnail {

  @Id
  @Column(name = "object_id")
  private UUID objectId;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @MapsId
  @JoinColumn(name = "object_id", referencedColumnName = "object_id", nullable = false, foreignKey = @ForeignKey(name = "fk_thumbnails_object_id"))
  private FileStorageItem fileStorageItem;

  @Column(name = "file_name", columnDefinition = "TEXT")
  private String fileName;

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
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Thumbnail thumbnail = (Thumbnail) o;
    return Objects.equals(objectId, thumbnail.objectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("objectId", objectId)
        .toString();
  }
}
