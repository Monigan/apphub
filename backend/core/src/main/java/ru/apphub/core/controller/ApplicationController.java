package ru.apphub.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.apphub.core.exceptions.ApplicationAlreadyExistException;
import ru.apphub.core.model.Applications;
import ru.apphub.core.model.FullApplicationModel;
import ru.apphub.core.request.AddScreenReviewCategorieToAppRequest;
import ru.apphub.core.request.ApplicationRegistrationRequest;
import ru.apphub.core.request.ApplicationUpdatePathFileRequest;
import ru.apphub.core.request.FullUpdateApplicationRequest;
import ru.apphub.core.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping(path = {"/applications"})
public class ApplicationController {
    private final ApplicationService applicationService;


    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody ApplicationRegistrationRequest application){
        try {
            applicationService.registration(application);
            return ResponseEntity.ok("Приложение успешно добавлено.");
        }catch (ApplicationAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }
    @GetMapping(path = {"/search/{id}"})
    public ResponseEntity<FullApplicationModel> getOneApplication(@PathVariable Long id){
        return ResponseEntity.ok(applicationService.getOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Applications>> listAllApplications() {
        return ResponseEntity.ok(applicationService.findAllApplications());
    }

    @PutMapping("/update")
    public ResponseEntity<Applications> update(@RequestBody ApplicationUpdatePathFileRequest applicationUpdatePathFileRequest) {
        return ResponseEntity.ok(applicationService.update(applicationUpdatePathFileRequest));
    }
    @PutMapping("/icon")
    public ResponseEntity<Applications> setIcon(@RequestBody ApplicationUpdatePathFileRequest applicationUpdatePathFileRequest) {
        return ResponseEntity.ok(applicationService.setIcon(applicationUpdatePathFileRequest));
    }
    @PutMapping("/review")
    public ResponseEntity<FullApplicationModel> addReview(@RequestBody AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest) {
        return ResponseEntity.ok(applicationService.addReview(addScreenshotToAppModelRequest));
    }
    @PutMapping("/categorie")
    public ResponseEntity<FullApplicationModel> addCategorie(@RequestBody AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest) {
        return ResponseEntity.ok(applicationService.addCategorie(addScreenshotToAppModelRequest));
    }
    @PostMapping("/screenshot")
    public ResponseEntity<FullApplicationModel> addScreenshot(@RequestBody AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest) {
        return ResponseEntity.ok(applicationService.addScreenshot(addScreenshotToAppModelRequest));
    }

    @PutMapping("/fupdate")
    public ResponseEntity<FullApplicationModel> fupdate(@RequestBody FullUpdateApplicationRequest model) {
        return ResponseEntity.ok(applicationService.fupdate(model));
    }


}
