package com.example.simple_form.repository;

import com.example.simple_form.model.usersmodel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Userrepository extends JpaRepository<usersmodel,Integer> {
    Optional<usersmodel> findByLoginAndPassword(String login, String password);
}
