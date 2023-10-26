package com.example.rschirpr5.repository;

import com.example.rschirpr5.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}