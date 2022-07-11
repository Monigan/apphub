package ru.apphub.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    @Column(name = "name", columnDefinition = "text", nullable = false)
    private String name;

    @Basic
    @Column(name = "path_file", columnDefinition = "text", nullable = false)
    private String path_file;

    @Basic
    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;


    //TODO Реализовать коллекцию отзывов и скриншотов
//    @Basic
//    @Column(name = "screenshots", columnDefinition = "text", nullable = false)
//    private Collection<Screenshot> screenshots;
//
//    @Basic
//    @Column(name = "reviews", nullable = false)
//    private Collection<Reviews> reviews;

    @Basic
    @Column(name = "rating", nullable = false)
    private double rating;

}
