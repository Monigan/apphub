package ru.apphub.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.apphub.core.controller.CategorieController;
import ru.apphub.core.entity.CategorieEntity;
import ru.apphub.core.entity.ReviewsEntity;

public interface CategorieRepo extends JpaRepository<CategorieEntity, Long> {
    CategorieEntity getOne(Long id);
}
