package ru.apphub.core.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FullUpdateApplicationRequest {
    private long id;

    private String name;

    private String path_file;

    private String fullDescription;

    private String shortDescription;

    private Double rating;

    private String descrSize;

    private String descrMPAA;

    private String descrAuthor;
}
