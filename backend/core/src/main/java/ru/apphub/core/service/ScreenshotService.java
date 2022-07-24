package ru.apphub.core.service;

import lombok.NonNull;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.request.ScreenshotaRegistrationRequest;

public interface ScreenshotService {
    ScreenshotEntity registration(ScreenshotaRegistrationRequest screenshotaRegistrationRequest);
    public ScreenshotEntity findById(Long id);
}
