package ru.apphub.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.apphub.core.entity.ReviewsEntity;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.service.ReviewsService;

public interface ReviewsRepo extends JpaRepository<ReviewsEntity, Long> {
    ReviewsEntity getOne(Long id);

}
