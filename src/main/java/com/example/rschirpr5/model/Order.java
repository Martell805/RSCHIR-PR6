package com.example.rschirpr5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String status;
    private Map<Integer, BookEntry> cart;
}
