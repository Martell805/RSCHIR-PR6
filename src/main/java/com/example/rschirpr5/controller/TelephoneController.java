package com.example.rschirpr5.controller;

import com.example.rschirpr5.model.Telephone;
import com.example.rschirpr5.repository.TelephoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("telephone")
@RequiredArgsConstructor
public class TelephoneController {
    private final TelephoneRepository telephoneRepository;

    @PostMapping
    public Telephone addTelephone(@RequestBody Telephone telephone) {
        return telephoneRepository.save(telephone);
    }

    @GetMapping
    public Telephone getTelephone(@RequestParam Integer id) {
        return telephoneRepository.findById(id).orElseThrow();
    }

    @GetMapping("all")
    public List<Telephone> getAllTelephones() {
        return telephoneRepository.findAll();
    }

    @PatchMapping
    public Telephone changeTelephone(@RequestBody Telephone telephone) {
        telephoneRepository.findById(telephone.getId()).orElseThrow();

        return telephoneRepository.save(telephone);
    }

    @DeleteMapping
    public Telephone deleteTelephone(@RequestParam Integer id) {
        Telephone telephone = telephoneRepository.findById(id).orElseThrow();

        telephoneRepository.deleteById(id);

        return telephone;
    }
}
