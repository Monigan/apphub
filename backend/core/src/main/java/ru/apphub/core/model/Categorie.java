package ru.apphub.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.apphub.core.entity.CategorieEntity;
import ru.apphub.core.entity.ReviewsEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
    private String categorie;


    public static Categorie toModel(CategorieEntity entity){
        Categorie model = new Categorie();
        model.setCategorie(entity.getCategorie());
        return model;
    }
    public static Collection<Categorie> toModelAll(Collection<CategorieEntity> entity){
        List<Categorie> model = new ArrayList<>();
        for(CategorieEntity reviewsEntity : entity){
            model.add(toModel(reviewsEntity));
        }
        return model;
    }
}
