package com.example.Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.Spring.model.Usuario;

public interface UsersRepositories extends JpaRepository<Usuario, Integer> {

}
