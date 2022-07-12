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

    private String description;
    private Boolean isPublished;
    @OneToMany
    @JoinColumn(name = "ids_screenshots")
    private Collection<ScreenshotEntity> screenshots;

    @OneToMany
    @JoinColumn(name = "ids_reviews")
    private Collection<ReviewsEntity> reviews;

    private Double rating;
}
