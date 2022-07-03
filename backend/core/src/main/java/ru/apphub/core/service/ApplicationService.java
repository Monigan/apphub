package ru.apphub.core.service;

import ru.apphub.core.model.Application;
import ru.apphub.core.model.User;

import java.util.List;

public interface ApplicationService {
    List<Application> findApplicationById(long id);
}
