package ru.apphub.core.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.apphub.core.model.User;
import ru.apphub.core.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }
}
