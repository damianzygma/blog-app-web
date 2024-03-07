package com.damianzygma.blogappweb.service;

import com.damianzygma.blogappweb.dto.RegistrationDto;
import com.damianzygma.blogappweb.entity.User;

public interface UserService {

    void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}
