package com.example.rschirpr5.controller;

import com.example.rschirpr5.model.BookEntry;
import com.example.rschirpr5.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public Map<Integer, BookEntry> getCart() {
        return cartService.getCart();
    }

    @GetMapping("add")
    public String addBooks(@RequestParam Integer id, @RequestParam Integer amount) {
        if (cartService.addBooks(id, amount)) {
            return "Books successfully added";
        }

        return "Not enough books in storage";
    }

    @GetMapping("remove")
    public String removeBooks(@RequestParam Integer id, @RequestParam Integer amount) {
        if (cartService.removeBooks(id, amount)) {
            return "Books successfully removed";
        }

        return "Not enough books in cart";
    }

    @GetMapping("clear")
    public String clearBooks() {
        cartService.clear();
        return "Cart successfully cleared";
    }

    @GetMapping("buy")
    public String buyBooks() {
        if (cartService.buy()) {
            return "Books successfully bought";
        }

        return "Not enough books in storage";
    }
}
