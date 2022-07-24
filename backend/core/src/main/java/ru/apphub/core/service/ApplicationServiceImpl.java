package ru.apphub.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.apphub.core.entity.ApplicationEntity;
import ru.apphub.core.entity.CategorieEntity;
import ru.apphub.core.entity.ReviewsEntity;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.exceptions.ApplicationAlreadyExistException;
import ru.apphub.core.model.Applications;
import ru.apphub.core.model.FullApplicationModel;
import ru.apphub.core.repository.ApplicationRepo;
import ru.apphub.core.request.AddScreenReviewCategorieToAppRequest;
import ru.apphub.core.request.ApplicationRegistrationRequest;
import ru.apphub.core.request.ApplicationUpdatePathFileRequest;
import ru.apphub.core.request.FullUpdateApplicationRequest;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional

public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepo applicationRepo;
    private final ScreenshotService screenshotService;
    private final ReviewsService reviewsService;
    private final CategorieService categorieService;
    @Autowired
    public ApplicationServiceImpl(ApplicationRepo applicationRepo, ScreenshotService screenshotService, ReviewsService reviewsService, CategorieService categorieService) {
        this.applicationRepo = applicationRepo;
        this.screenshotService = screenshotService;
        this.reviewsService = reviewsService;
        this.categorieService = categorieService;
    }


    @Override
    public List<Applications> findAllApplications() {
        return  applicationRepo.findAll().stream().map(Applications::toModel).toList();
    }

    @Override
    public ApplicationEntity registration(ApplicationRegistrationRequest application) throws ApplicationAlreadyExistException {
        if(applicationRepo.findByName(application.getName()) != null){
            throw new ApplicationAlreadyExistException("Приложение с таким именем уже существует.");
        }
        ApplicationEntity applicationEntity = new ApplicationEntity();
        applicationEntity.setFullDescription(application.getDescription());
        applicationEntity.setName(application.getName());
        return applicationRepo.save(applicationEntity);
    }

    @Override
    public Applications update(ApplicationUpdatePathFileRequest applicationUpdatePathFileRequest) {
        ApplicationEntity applicationEntity = applicationRepo.getOne(applicationUpdatePathFileRequest.getId());
        if (applicationEntity == null){
            throw new EntityNotFoundException("Приложение с таким Id не найден.");
        }
        applicationEntity.setPath_file(applicationUpdatePathFileRequest.getPath_file());
        applicationRepo.save(applicationEntity);
        return Applications.toModel(applicationEntity);
    }
    @Override
    public FullApplicationModel getOne(Long id){
        ApplicationEntity user = applicationRepo.getOne(id);
        if (user == null){
            throw new EntityNotFoundException("Приложение с таким Id не найден.");
        }
        return FullApplicationModel.toModel(user);
    }

    @Override
    public FullApplicationModel addScreenshot(AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest) {
        ApplicationEntity applicationEntity = applicationRepo.getOne(addScreenshotToAppModelRequest.getIdApplication());
        if (applicationEntity == null){
            throw new EntityNotFoundException("Приложение с таким Id не найден.");
        }

        if(addScreenshotToAppModelRequest.getIdSRC()==null) {
            applicationEntity.setScreenshots(null);
        }
        else{
            Collection<ScreenshotEntity> screenshotEntities = applicationEntity.getScreenshots();
            screenshotEntities.add(screenshotService.findById(addScreenshotToAppModelRequest.getIdSRC()));
            applicationEntity.setScreenshots(screenshotEntities);
        }
        applicationRepo.save(applicationEntity);
        return FullApplicationModel.toModel(applicationEntity);
    }

    @Override
    public Applications setIcon(ApplicationUpdatePathFileRequest applicationUpdatePathFileRequest) {
        ApplicationEntity applicationEntity = applicationRepo.getOne(applicationUpdatePathFileRequest.getId());
        if (applicationEntity == null){
            throw new EntityNotFoundException("Приложение с таким Id не найден.");
        }
        applicationEntity.setIcon_path_file(applicationUpdatePathFileRequest.getPath_file());
        applicationRepo.save(applicationEntity);
        return Applications.toModel(applicationEntity);
    }

    @Override
    public FullApplicationModel addReview(AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest) {
        ApplicationEntity applicationEntity = applicationRepo.getOne(addScreenshotToAppModelRequest.getIdApplication());
        if (applicationEntity == null){
            throw new EntityNotFoundException("Приложение с таким Id не найден.");
        }

        if(addScreenshotToAppModelRequest.getIdSRC()!=null) {
            Collection<ReviewsEntity> entityReviews = applicationEntity.getReviews();
            entityReviews.add(reviewsService.findById(addScreenshotToAppModelRequest.getIdSRC()));
            applicationEntity.setReviews(entityReviews);
        }else{
            throw new EntityNotFoundException("Комментарий с таким Id не найден.");
        }
        applicationRepo.save(applicationEntity);
        return FullApplicationModel.toModel(applicationEntity);
    }

    @Override
    public FullApplicationModel addCategorie(AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest) {
        ApplicationEntity applicationEntity = applicationRepo.getOne(addScreenshotToAppModelRequest.getIdApplication());
        if (applicationEntity == null){
            throw new EntityNotFoundException("Приложение с таким Id не найден.");
        }

        if(addScreenshotToAppModelRequest.getIdSRC()!=null) {
            Collection<CategorieEntity> entityReviews = applicationEntity.getCategorie();
            entityReviews.add(categorieService.findById(addScreenshotToAppModelRequest.getIdSRC()));
            applicationEntity.setCategorie(entityReviews);
        }else{
            throw new EntityNotFoundException("Категория с таким Id не найден.");
        }
        applicationRepo.save(applicationEntity);
        return FullApplicationModel.toModel(applicationEntity);
    }

    @Override
    public FullApplicationModel fupdate(FullUpdateApplicationRequest model) {
        ApplicationEntity applicationEntity = applicationRepo.getOne(model.getId());
        if (applicationEntity == null){
            throw new EntityNotFoundException("Приложение с таким Id не найден.");
        }
        if (model.getName()!=null)
            applicationEntity.setName(model.getName());
        if (model.getPath_file()!=null)
            applicationEntity.setPath_file(model.getPath_file());
        if (model.getDescrAuthor()!=null)
            applicationEntity.setDescrAuthor(model.getDescrAuthor());
        if (model.getFullDescription()!=null)
            applicationEntity.setFullDescription(model.getFullDescription());
        if (model.getShortDescription()!=null)
            applicationEntity.setShortDescription(model.getShortDescription());
        if (model.getDescrSize()!=null)
            applicationEntity.setDescrSize(model.getDescrSize());
        if (model.getDescrMPAA()!=null)
            applicationEntity.setDescrMPAA(model.getDescrMPAA());
        if (model.getRating()!=null)
            applicationEntity.setRating(model.getRating());
        applicationRepo.save(applicationEntity);
        return FullApplicationModel.toModel(applicationEntity);
    }
}
