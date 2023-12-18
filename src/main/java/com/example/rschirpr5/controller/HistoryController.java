package com.example.rschirpr5.controller;

import com.example.rschirpr5.model.Order;
import com.example.rschirpr5.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("history")
@AllArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public List<Order> getHistory() {
        return historyService.getHistory();
    }
}
