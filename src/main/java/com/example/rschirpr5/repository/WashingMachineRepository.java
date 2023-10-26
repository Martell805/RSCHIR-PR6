package com.example.rschirpr5.repository;

import com.example.rschirpr5.model.WashingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WashingMachineRepository extends JpaRepository<WashingMachine, Integer> {
}