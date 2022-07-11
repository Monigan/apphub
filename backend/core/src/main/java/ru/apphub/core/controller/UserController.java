package ru.apphub.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.apphub.core.entity.UserEntity;
import ru.apphub.core.model.User;
import ru.apphub.core.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;



  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<UserEntity> registration(@RequestBody UserEntity user){
      return ResponseEntity.ok(userService.registration(user));
  }

  //TODO Не комплится приложение, исправить
  @GetMapping(path = {"/{login}"})
  public ResponseEntity<User> getOneUser(@PathVariable String login){
      return ResponseEntity.ok(userService.getOne(login));
  }

//  @DeleteMapping
//  public ResponseEntity deleteUser(@RequestParam String login){
//
//  }

  @GetMapping
  public ResponseEntity<List<User>> listAllUsers() {
    return ResponseEntity.ok(userService.findAllUsers());
  }
}
