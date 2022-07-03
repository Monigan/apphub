package ru.apphub.core.model;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.usertype.UserType;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Basic
  @Column(name = "last_name", columnDefinition = "text")
  private String lastName;

  @Basic
  @Column(name = "first_name", columnDefinition = "text")
  private String firstName;

  @Basic
  @Column(name = "login", columnDefinition = "text", nullable = false)
  private String login;

  @Basic
  @Column(name = "password", columnDefinition = "text", nullable = false)
  private String password;

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
