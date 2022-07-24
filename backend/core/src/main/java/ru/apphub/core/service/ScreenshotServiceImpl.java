package ru.apphub.core.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.apphub.core.entity.ApplicationEntity;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.entity.UserEntity;
import ru.apphub.core.exceptions.ApplicationAlreadyExistException;
import ru.apphub.core.repository.ApplicationRepo;
import ru.apphub.core.repository.ScreenshotRepo;
import ru.apphub.core.request.ApplicationRegistrationRequest;
import ru.apphub.core.request.ScreenshotaRegistrationRequest;

import javax.transaction.Transactional;

@Service
@Transactional
public class ScreenshotServiceImpl implements ScreenshotService{
    private final ScreenshotRepo screenshotRepo;
    @Autowired
    public ScreenshotServiceImpl(ScreenshotRepo screenshotRepo) {
        this.screenshotRepo = screenshotRepo;
    }
    @Override
    public ScreenshotEntity registration(ScreenshotaRegistrationRequest screenshotaRegistrationRequest) {
        ScreenshotEntity screenshotEntity = new ScreenshotEntity();
        screenshotEntity.setPath_file(screenshotaRegistrationRequest.getPath_file());
        return screenshotRepo.save(screenshotEntity);
    }

    @Override
    public ScreenshotEntity findById(Long id) {
        return this.screenshotRepo.getOne(id);
    }

}
