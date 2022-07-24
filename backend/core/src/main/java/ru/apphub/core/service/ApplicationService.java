package ru.apphub.core.service;

import ru.apphub.core.entity.ApplicationEntity;
import ru.apphub.core.exceptions.ApplicationAlreadyExistException;
import ru.apphub.core.model.Applications;
import ru.apphub.core.model.FullApplicationModel;
import ru.apphub.core.request.AddScreenReviewCategorieToAppRequest;
import ru.apphub.core.request.ApplicationRegistrationRequest;
import ru.apphub.core.request.ApplicationUpdatePathFileRequest;
import ru.apphub.core.request.FullUpdateApplicationRequest;

import java.util.List;

public interface ApplicationService {
    List<Applications> findAllApplications();
    ApplicationEntity registration(ApplicationRegistrationRequest application) throws ApplicationAlreadyExistException;
    Applications update(ApplicationUpdatePathFileRequest applicationUpdatePathFileRequest);
    FullApplicationModel getOne(Long id);
    FullApplicationModel addScreenshot(AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest);
    Applications setIcon(ApplicationUpdatePathFileRequest applicationUpdatePathFileRequest);

    FullApplicationModel addReview(AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest);

    FullApplicationModel addCategorie(AddScreenReviewCategorieToAppRequest addScreenshotToAppModelRequest);

    FullApplicationModel fupdate(FullUpdateApplicationRequest model);
}
