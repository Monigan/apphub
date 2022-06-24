package ru.apphub.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.apphub.core.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
