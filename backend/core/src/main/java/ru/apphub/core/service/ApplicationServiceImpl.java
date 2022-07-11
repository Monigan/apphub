package ru.apphub.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.apphub.core.exceptions.ApplicationAlreadyExistException;
import ru.apphub.core.model.Application;
import ru.apphub.core.repository.ApplicationRepo;
import ru.apphub.core.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepo applicationRepo;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }


    @Override
    public List<Application> findAllApplications() {
        return  applicationRepo.findAll();
    }

    @Override
    public Application registration(Application application) throws ApplicationAlreadyExistException {
        if(applicationRepo.findByName(application.getName()) != null){
            throw new ApplicationAlreadyExistException("Приложение с таким именем уже существует.");
        }
        return applicationRepo.save(application);
    }


}
