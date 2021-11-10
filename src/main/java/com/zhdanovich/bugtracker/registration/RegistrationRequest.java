package com.zhdanovich.bugtracker.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
