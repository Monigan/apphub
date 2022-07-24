package ru.apphub.core.service;

import ru.apphub.core.entity.CategorieEntity;
import ru.apphub.core.entity.ReviewsEntity;
import ru.apphub.core.model.Applications;
import ru.apphub.core.model.Categorie;
import ru.apphub.core.request.CategorieRegistrationRequest;
import ru.apphub.core.request.ReviewRegistrationRequest;

import java.util.List;

public interface CategorieService {
    List<Categorie> findAllCategorie();
    CategorieEntity registration(CategorieRegistrationRequest categorieRegistrationRequest);

    CategorieEntity findById(Long idSRC);
}
