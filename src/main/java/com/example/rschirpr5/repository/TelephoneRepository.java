package com.example.rschirpr5.repository;

import com.example.rschirpr5.model.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {
}