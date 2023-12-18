package com.example.rschirpr5.service;

import com.example.rschirpr5.model.BookEntry;
import com.example.rschirpr5.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService {
    @Getter
    private final List<Order> history = new ArrayList<>();

    public void onBuy(Map<Integer, BookEntry> cart) {
        history.add(new Order("SUCCESS", new HashMap<>(cart)));
    }

    public void onClear(Map<Integer, BookEntry> cart) {
        history.add(new Order("CANCELED", new HashMap<>(cart)));
    }
}
