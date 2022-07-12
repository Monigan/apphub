package ru.apphub.core.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Setter
@Getter
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


    private String email;


    private String phone;


    //private UserType user_type;

    @OneToMany
    @JoinColumn(name = "ids_applications")
    private Collection<ApplicationEntity> applications;
    @OneToMany
    @JoinColumn(name = "ids_your_applications")
    private Collection<ApplicationEntity> your_applications;
}
