package ru.apphub.core.service;

import ru.apphub.core.exceptions.ApplicationAlreadyExistException;
import ru.apphub.core.model.Application;
import ru.apphub.core.model.User;

import java.util.List;

public interface ApplicationService {
    List<Application> findAllApplications();
    Application registration(Application application) throws ApplicationAlreadyExistException;
}
