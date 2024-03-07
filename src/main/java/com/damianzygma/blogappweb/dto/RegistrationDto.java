package com.damianzygma.blogappweb.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private Long id;

    @NotEmpty(message = "should not be empty")
    private String firstName;

    @NotEmpty(message = "should not be empty")
    private String lastName;

    @NotEmpty(message = "should not be empty or null")
    @Email
    private String email;

    @NotEmpty(message = "should not be empty")
    private String password;

}
