package ru.apphub.core.service;

import java.util.List;



import ru.apphub.core.entity.UserEntity;
import ru.apphub.core.model.User;
import ru.apphub.core.request.UserRegistrationRequest;

public interface UserService {
  List<User> findAllUsers();
  UserEntity registration(UserRegistrationRequest user);

  User findByLogin(String login);
  User getOne(Long id);
}
