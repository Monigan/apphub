package ru.apphub.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.apphub.core.exceptions.ApplicationAlreadyExistException;
import ru.apphub.core.model.Application;
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
    public ResponseEntity registration(@RequestBody Application application){
        try {
            applicationService.registration(application);
            return ResponseEntity.ok("Приложение успешно добавлено.");
        }catch (ApplicationAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Application>> listAllApplications() {
        return ResponseEntity.ok(applicationService.findAllApplications());
    }
}
