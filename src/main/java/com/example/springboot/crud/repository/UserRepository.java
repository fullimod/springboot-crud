package com.example.springboot.crud.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.crud.dto.UserDAO;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Serializable>{

}
