package ru.apphub.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.service.ReviewsService;
import ru.apphub.core.service.ScreenshotService;

public interface ScreenshotRepo extends JpaRepository<ScreenshotEntity, Long> {
    ScreenshotEntity getOne(Long id);
}
