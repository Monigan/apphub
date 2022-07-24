package ru.apphub.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.apphub.core.entity.ReviewsEntity;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.repository.ReviewsRepo;
import ru.apphub.core.repository.ScreenshotRepo;
import ru.apphub.core.request.ReviewRegistrationRequest;

import javax.transaction.Transactional;


@Service
@Transactional
public class ReviewsServiceImpl implements ReviewsService{

    private final ReviewsRepo reviewsRepo;

    @Autowired
    public ReviewsServiceImpl(ReviewsRepo reviewsRepo) {
        this.reviewsRepo = reviewsRepo;
    }

    @Override
    public ReviewsEntity registration(ReviewRegistrationRequest reviewRegistrationRequest) {
        ReviewsEntity reviewsEntity = new ReviewsEntity();
        reviewsEntity.setReview(reviewRegistrationRequest.getReview());
        reviewsEntity.setRating(reviewRegistrationRequest.getRating());
        return reviewsRepo.save(reviewsEntity);
    }

    @Override
    public ReviewsEntity findById(Long id) {
        return this.reviewsRepo.getOne(id);
    }
}
