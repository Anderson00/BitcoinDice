package com.example.Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.model.Payments;

public interface PaymentsRepositories extends JpaRepository<Payments, Integer>{

}
