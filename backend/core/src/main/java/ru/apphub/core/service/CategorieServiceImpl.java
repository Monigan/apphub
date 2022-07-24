package ru.apphub.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.apphub.core.entity.CategorieEntity;
import ru.apphub.core.entity.ReviewsEntity;
import ru.apphub.core.model.Applications;
import ru.apphub.core.model.Categorie;
import ru.apphub.core.repository.CategorieRepo;
import ru.apphub.core.request.CategorieRegistrationRequest;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class CategorieServiceImpl implements CategorieService{

    private final CategorieRepo categorieRepo;
    @Autowired
    public CategorieServiceImpl(CategorieRepo categorieRepo) {
        this.categorieRepo = categorieRepo;
    }


    @Override
    public List<Categorie> findAllCategorie() {
        return  categorieRepo.findAll().stream().map(Categorie::toModel).toList();
    }

    @Override
    public CategorieEntity registration(CategorieRegistrationRequest categorieRegistrationRequest) {
        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setCategorie(categorieRegistrationRequest.getCategorie());
        return categorieRepo.save(categorieEntity);
    }

    @Override
    public CategorieEntity findById(Long id) {
        return this.categorieRepo.getOne(id);
    }
}
