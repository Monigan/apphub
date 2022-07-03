package ru.apphub.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.apphub.core.model.Application;
import ru.apphub.core.model.User;
import ru.apphub.core.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public ResponseEntity<List<Application>> listApplication(long id) {
        return ResponseEntity.ok(applicationService.findApplicationById(id));
    }
}
