package ru.apphub.core.entity;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", columnDefinition = "text")
    private String last_name;

    @Column(name = "first_name", columnDefinition = "text")
    private String first_name;

    @Column(name = "login", columnDefinition = "text", nullable = false)
    private String login;


    @Column(name = "password", columnDefinition = "text", nullable = false)
    private String password;

    //TODO реализовать пункты ниже(e-mail, phone, коллекции).
//  @Column(name = "email", columnDefinition = "text", nullable = false)
//  private String email;
//
//  @Column(name = "phone", columnDefinition = "text", nullable = false)
//  private String phone;
//
//  @Column(name = "user_type", columnDefinition = "text", nullable = false)
//  private UserType userType;
//
//  @Column(name = "applications", columnDefinition = "text", nullable = false)
//  private Collection<Application> applications;

    public Long getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
