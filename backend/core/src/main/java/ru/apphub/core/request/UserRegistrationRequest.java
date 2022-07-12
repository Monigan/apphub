package ru.apphub.core.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {

    private String login;

    private String password;

    private String last_name;

    private String first_name;

}
