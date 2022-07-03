package ru.apphub.core.service;

import org.springframework.stereotype.Service;
import ru.apphub.core.model.Application;
import ru.apphub.core.repository.ApplicationRepo;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepo applicationRepo;

    public ApplicationServiceImpl(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    @Override
    public List<Application> findApplicationById(long id){
        return applicationRepo.findAllById(Collections.singleton(id));
    }
}
