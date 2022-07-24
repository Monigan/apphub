package ru.apphub.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.apphub.core.entity.ReviewsEntity;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.request.ReviewRegistrationRequest;
import ru.apphub.core.request.ScreenshotaRegistrationRequest;
import ru.apphub.core.service.ReviewsService;
import ru.apphub.core.service.ScreenshotService;

@RestController
@RequestMapping(path = {"/reviews"})
public class ReviewsController {
    private final ReviewsService reviewsService;
    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping
    public ResponseEntity<ReviewsEntity> registration(@RequestBody ReviewRegistrationRequest reviewRegistrationRequest){
        return ResponseEntity.ok(reviewsService.registration(reviewRegistrationRequest));
    }
}
