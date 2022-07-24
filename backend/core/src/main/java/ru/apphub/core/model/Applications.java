package ru.apphub.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.apphub.core.entity.ApplicationEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Applications {


    private long id;

    private String name;

    private String icon_path_file;



    public static Applications toModel(ApplicationEntity entity){
        Applications model = new Applications();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setIcon_path_file(entity.getIcon_path_file());
        return model;
    }
    //TODO Реализовать коллекцию отзывов и скриншотов
//    @Basic
//    @Column(name = "screenshots", columnDefinition = "text", nullable = false)
//    private Collection<Screenshot> screenshots;
//
//    @Basic
//    @Column(name = "reviews", nullable = false)
//    private Collection<Reviews> reviews;



}
