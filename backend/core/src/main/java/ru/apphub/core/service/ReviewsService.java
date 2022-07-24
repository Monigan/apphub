package ru.apphub.core.service;

import ru.apphub.core.entity.ReviewsEntity;
import ru.apphub.core.request.ReviewRegistrationRequest;

public interface ReviewsService {
    ReviewsEntity registration(ReviewRegistrationRequest reviewRegistrationRequest);

    ReviewsEntity findById(Long idScreenshot);
}
