package ru.apphub.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "application")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String path_file;
    private String icon_path_file;
    private String fullDescription;
    private String shortDescription;
    private Boolean isPublished;
    private String descrSize;
    private String descrMPAA;
    private String descrAuthor;


    @OneToMany
    @JoinColumn(name = "ids_screenshots")
    private Collection<ScreenshotEntity> screenshots;

    @OneToMany
    @JoinColumn(name = "ids_reviews")
    private Collection<ReviewsEntity> reviews;

    @ManyToMany
    @JoinColumn(name = "ids_categorie")
    private Collection<CategorieEntity> categorie;

    private Double rating;
}
