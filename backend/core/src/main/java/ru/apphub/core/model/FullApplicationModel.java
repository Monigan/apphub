package ru.apphub.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.apphub.core.entity.ApplicationEntity;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullApplicationModel {
    private long id;

    private String name;

    private String path_file;

    private String fullDescription;

    private String shortDescription;

    private Double rating;

    private Collection<Screenshot> screenshots;

    private Collection<Review> reviews;

    private Collection<Categorie> categorie;
    private String descrSize;
    private String descrMPAA;
    private String descrAuthor;
    public static FullApplicationModel toModel(ApplicationEntity entity){
        FullApplicationModel model = new FullApplicationModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setFullDescription(entity.getFullDescription());
        model.setShortDescription(entity.getShortDescription());
        model.setPath_file(entity.getPath_file());
        model.setRating(entity.getRating());
        model.setScreenshots(Screenshot.toModelAll(entity.getScreenshots()));
        model.setReviews(Review.toModelAll(entity.getReviews()));
        model.setCategorie(Categorie.toModelAll(entity.getCategorie()));
        model.setDescrAuthor(entity.getDescrAuthor());
        model.setDescrMPAA(entity.getDescrMPAA());
        model.setDescrSize(entity.getDescrSize());
        return model;
    }
}
