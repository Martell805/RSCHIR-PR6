package com.example.rschirpr5.controller;

import com.example.rschirpr5.model.Client;
import com.example.rschirpr5.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepository clientRepository;

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping
    public Client getClient(@RequestParam Integer id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @GetMapping("all")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PatchMapping
    public Client changeClient(@RequestBody Client client) {
        clientRepository.findById(client.getId()).orElseThrow();

        return clientRepository.save(client);
    }

    @DeleteMapping
    public Client deleteClient(@RequestParam Integer id) {
        Client client = clientRepository.findById(id).orElseThrow();

        clientRepository.deleteById(id);

        return client;
    }
}
