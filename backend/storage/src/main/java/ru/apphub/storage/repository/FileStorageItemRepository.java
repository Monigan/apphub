package ru.apphub.storage.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.apphub.storage.model.FileStorageItem;

public interface FileStorageItemRepository extends JpaRepository<FileStorageItem, UUID> {

  Optional<FileStorageItem> findByObjectIdOrFileName(UUID objectId, String fileName);

  Optional<FileStorageItem> findByOldFileStorageName(String oldFileStorageName);
}
