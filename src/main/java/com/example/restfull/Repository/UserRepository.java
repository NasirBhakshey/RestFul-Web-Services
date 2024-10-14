package com.example.restfull.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfull.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
