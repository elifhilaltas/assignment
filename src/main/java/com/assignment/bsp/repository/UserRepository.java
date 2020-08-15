package com.assignment.bsp.repository;


import com.assignment.bsp.domain.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {

}