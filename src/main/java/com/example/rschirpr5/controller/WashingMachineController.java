package com.example.rschirpr5.controller;

import com.example.rschirpr5.model.WashingMachine;
import com.example.rschirpr5.repository.WashingMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("washingMachine")
@RequiredArgsConstructor
public class WashingMachineController {
    private final WashingMachineRepository washingMachineRepository;

    @PostMapping
    public WashingMachine addWashingMachine(@RequestBody WashingMachine washingMachine) {
        return washingMachineRepository.save(washingMachine);
    }

    @GetMapping
    public WashingMachine getWashingMachine(@RequestParam Integer id) {
        return washingMachineRepository.findById(id).orElseThrow();
    }

    @GetMapping("all")
    public List<WashingMachine> getAllWashingMachines() {
        return washingMachineRepository.findAll();
    }

    @PatchMapping
    public WashingMachine changeWashingMachine(@RequestBody WashingMachine washingMachine) {
        washingMachineRepository.findById(washingMachine.getId()).orElseThrow();

        return washingMachineRepository.save(washingMachine);
    }

    @DeleteMapping
    public WashingMachine deleteWashingMachine(@RequestParam Integer id) {
        WashingMachine washingMachine = washingMachineRepository.findById(id).orElseThrow();

        washingMachineRepository.deleteById(id);

        return washingMachine;
    }
}
