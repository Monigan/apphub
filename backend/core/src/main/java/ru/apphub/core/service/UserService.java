package ru.apphub.core.service;

import java.util.List;

import ru.apphub.core.entity.UserEntity;
import ru.apphub.core.model.User;

public interface UserService {
  List<UserEntity> findAllUsers();
  UserEntity registration(UserEntity user);

  User getOne(String login);
}
