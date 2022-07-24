package ru.apphub.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.entity.UserEntity;
import ru.apphub.core.model.User;
import ru.apphub.core.request.ScreenshotaRegistrationRequest;
import ru.apphub.core.request.UserRegistrationRequest;
import ru.apphub.core.service.ScreenshotService;


@RestController
@RequestMapping(path = {"/screenshot"})
public class ScreenshotController {
    private final ScreenshotService screenshotService;
    @Autowired
    public ScreenshotController(ScreenshotService screenshotService) {
        this.screenshotService = screenshotService;
    }

    @PostMapping
    public ResponseEntity<ScreenshotEntity> registration(@RequestBody ScreenshotaRegistrationRequest screenshotaRegistrationRequest){
        return ResponseEntity.ok(screenshotService.registration(screenshotaRegistrationRequest));
    }
}
