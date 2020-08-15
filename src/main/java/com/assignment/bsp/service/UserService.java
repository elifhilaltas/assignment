package com.assignment.bsp.service;


import com.assignment.bsp.domain.Users;
import com.assignment.bsp.exception.UserNotFoundException;
import com.assignment.bsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    @Autowired
    UserRepository userRepository;


    private Users toEntity(Users user) {
        Users entity = new Users();
        entity.setName(user.getName());
        entity.setSurname(user.getSurname());
        entity.setPassword(user.getPassword());
        entity.setUsername(user.getUsername());
        entity.setPhone(user.getPhone());
        entity.setEnabled(user.isEnabled());
        return entity;
    }

    public void add(Users user){
        userRepository.save(toEntity(user));
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public List<Users> getUsers(){
        return (List<Users>) userRepository.findAll();
        }

    public Users getUserById(Long id){
        Optional<Users> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() ->new UserNotFoundException(" Could not found User with id :"+ id));
    }


}
