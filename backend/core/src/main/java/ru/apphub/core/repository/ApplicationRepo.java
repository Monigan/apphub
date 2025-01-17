package ru.apphub.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.apphub.core.model.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
    Application findByName(String name);
}
