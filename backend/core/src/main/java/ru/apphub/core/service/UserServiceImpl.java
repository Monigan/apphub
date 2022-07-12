package ru.apphub.core.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.apphub.core.entity.UserEntity;
import ru.apphub.core.exceptions.UserAlreadyExistException;
import ru.apphub.core.model.User;
import ru.apphub.core.repository.UserRepository;
import ru.apphub.core.request.UserRegistrationRequest;

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
    return userRepository.findAll().stream().map(User::toModel).toList();
//    return userRepository.findAll().stream().toList();
  }

  @Override
  public UserEntity registration(UserRegistrationRequest user){
    if(userRepository.findByLogin(user.getLogin()) != null){
      throw new UserAlreadyExistException("Пользователь с таким именем уже существует.");
    }
    //TODO по аналогии с емейлами и номерами телефонов вывод ошибок
    UserEntity userEntity = new UserEntity();
    userEntity.setLogin(user.getLogin());
    userEntity.setPassword(user.getPassword());
    userEntity.setFirst_name(user.getFirst_name());
    userEntity.setLast_name(user.getLast_name());
    return userRepository.save(userEntity);
  }

  @Override
  public User getOne(String login){
    UserEntity user = userRepository.findByLogin(login);
    if (user == null){
        throw new EntityNotFoundException("Пользователь с таким Login не найден.");
    }
    return User.toModel(user);
  }

}
