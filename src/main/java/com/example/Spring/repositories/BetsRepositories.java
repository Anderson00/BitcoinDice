package com.example.Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.model.Bet;

public interface BetsRepositories extends JpaRepository<Bet, Integer>{

}
