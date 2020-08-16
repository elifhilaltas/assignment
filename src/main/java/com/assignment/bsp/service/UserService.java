package com.assignment.bsp.service;


import com.assignment.bsp.domain.Users;
import com.assignment.bsp.exception.UserNotFoundException;
import com.assignment.bsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    private Users toEntity(Users user) {
        Users entity = new Users();
        entity.setName(user.getName());
        entity.setSurname(user.getSurname());
        entity.setPassword(user.getPassword());
        entity.setUsername(user.getUsername());
        entity.setPhone(user.getPhone());
        entity.setEnabled(true);
        return entity;
    }

    public void add(Users user){
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(toEntity(user));

    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
