package ru.apphub.core.service;

import java.util.List;
import ru.apphub.core.model.User;

public interface UserService {
  List<User> findAllUsers();
}
