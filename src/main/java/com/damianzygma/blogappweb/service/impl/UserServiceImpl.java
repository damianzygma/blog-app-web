package com.damianzygma.blogappweb.service.impl;

import com.damianzygma.blogappweb.dto.RegistrationDto;
import com.damianzygma.blogappweb.entity.Role;
import com.damianzygma.blogappweb.entity.User;
import com.damianzygma.blogappweb.repository.RoleRepository;
import com.damianzygma.blogappweb.repository.UserRepository;
import com.damianzygma.blogappweb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setName(registrationDto.getFirstName() + " " + registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        // use spring security to encrypt the password
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
