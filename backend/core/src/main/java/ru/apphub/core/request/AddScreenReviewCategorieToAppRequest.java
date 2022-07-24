package ru.apphub.core.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddScreenReviewCategorieToAppRequest {

    Long idApplication;
    Long idSRC;

}
