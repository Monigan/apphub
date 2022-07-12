package ru.apphub.core.model;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.apphub.core.entity.UserEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {


  private Long id;

  private String last_name;

  private String first_name;




  //TODO реализовать пункты ниже(e-mail, phone, коллекции).
//  @Basic
//  @Column(name = "email", columnDefinition = "text", nullable = false)
//  private String email;
//
//  @Basic
//  @Column(name = "phone", columnDefinition = "text", nullable = false)
//  private String phone;
//
//  @Basic
//  @Column(name = "user_type", columnDefinition = "text", nullable = false)
//  private UserType userType;
//
//  @Basic
//  @Column(name = "applications", columnDefinition = "text", nullable = false)
//  private Collection<Application> applications;




  public static User toModel(UserEntity entity){
    User model = new User();
    model.setId(entity.getId());
    model.setFirst_name(entity.getFirst_name());
    model.setLast_name(entity.getLast_name());
    return model;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
