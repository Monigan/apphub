package ru.apphub.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.apphub.core.entity.ApplicationEntity;
import ru.apphub.core.model.Applications;

@Repository
public interface ApplicationRepo extends JpaRepository<ApplicationEntity, Long> {
    Applications findByName(String name);

    ApplicationEntity getOne(Long id);
}
