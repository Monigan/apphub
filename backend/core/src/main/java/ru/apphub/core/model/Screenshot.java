package ru.apphub.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.apphub.core.entity.ApplicationEntity;
import ru.apphub.core.entity.ScreenshotEntity;
import ru.apphub.core.repository.ScreenshotRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Screenshot {
    String path_file;
    public static Screenshot toModel(ScreenshotEntity entity){
        Screenshot model = new Screenshot();
        model.setPath_file(entity.getPath_file());
        return model;
    }
    public static Collection<Screenshot> toModelAll(Collection<ScreenshotEntity> entity){
        List<Screenshot> model = new ArrayList<>();
        for(ScreenshotEntity screenshotEntity : entity){
            model.add(toModel(screenshotEntity));
        }
        return model;
    }
}
