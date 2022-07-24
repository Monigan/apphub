package ru.apphub.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.apphub.core.entity.CategorieEntity;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.model.Categorie;
import ru.apphub.core.request.CategorieRegistrationRequest;
import ru.apphub.core.request.ScreenshotaRegistrationRequest;
import ru.apphub.core.service.CategorieService;

import java.util.List;

@RestController
@RequestMapping(path = {"/categorie"})
public class CategorieController {

    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> listAllApplications() {
        return ResponseEntity.ok(categorieService.findAllCategorie());
    }
    @PostMapping
    public ResponseEntity<CategorieEntity> registration(@RequestBody CategorieRegistrationRequest categorieRegistrationRequest){
        return ResponseEntity.ok(categorieService.registration(categorieRegistrationRequest));
    }
}
