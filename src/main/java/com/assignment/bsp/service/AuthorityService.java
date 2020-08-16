package com.assignment.bsp.service;

import com.assignment.bsp.domain.Authorities;
import com.assignment.bsp.repository.AuthorityRepository;
import com.assignment.bsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthorityService {

    @Autowired
    AuthorityRepository authorityRepository;



    private Authorities toEntity(Authorities role) {
        Authorities entity = new Authorities();
        entity.setUsername(role.getUsername());
        entity.setAuthority(role.getAuthority());
        return entity;
    }

    public void add(Authorities authorities){

        authorityRepository.save(toEntity(authorities));

    }


}
