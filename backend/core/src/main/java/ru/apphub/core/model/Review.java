package ru.apphub.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.apphub.core.entity.ReviewsEntity;
import ru.apphub.core.entity.ScreenshotEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private String review;
    private Double rating;

    public static Review toModel(ReviewsEntity entity){
        Review model = new Review();
        model.setReview(entity.getReview());
        model.setRating(entity.getRating());
        return model;
    }
    public static Collection<Review> toModelAll(Collection<ReviewsEntity> entity){
        List<Review> model = new ArrayList<>();
        for(ReviewsEntity reviewsEntity : entity){
            model.add(toModel(reviewsEntity));
        }
        return model;
    }
}
