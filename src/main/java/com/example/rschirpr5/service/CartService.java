package com.example.rschirpr5.service;

import com.example.rschirpr5.model.Book;
import com.example.rschirpr5.model.BookEntry;
import com.example.rschirpr5.repository.BookRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {
    @Getter
    private final Map<Integer, BookEntry> cart = new HashMap<>();
    private final BookRepository bookRepository;

    public Boolean addBooks(Integer id, Integer amount) {
        Book book = bookRepository.findById(id).orElseThrow();

        if (!cart.containsKey(id)) {
            if(book.getAmount() >= amount) {
                cart.put(id, new BookEntry(book, amount));
                return true;
            }

            return false;
        }

        BookEntry bookEntry = cart.get(id);
        if (book.getAmount() >= amount + bookEntry.getAmount()) {
            cart.put(id, new BookEntry(book, amount + bookEntry.getAmount()));
            return true;
        }

        return false;
    }

    public Boolean removeBooks(Integer id, Integer amount) {
        if (!cart.containsKey(id)) {
            return false;
        }

        BookEntry bookEntry = cart.get(id);
        if (bookEntry.getAmount() > amount) {
            bookEntry.setAmount(bookEntry.getAmount() - amount);
            cart.put(id, bookEntry);
            return true;
        }

        if (bookEntry.getAmount().equals(amount)) {
            cart.remove(id);
            return true;
        }

        return false;
    }

    public Boolean clear() {
        cart.clear();
        return true;
    }

    public Boolean buy() {
        for (BookEntry bookEntry: cart.values()) {
            Book book = bookRepository.findById(bookEntry.getBook().getId()).orElseThrow();
            if (book.getAmount() < bookEntry.getAmount()) {
                return false;
            }
        }

        for (BookEntry bookEntry: cart.values()) {
            Book book = bookRepository.findById(bookEntry.getBook().getId()).orElseThrow();
            book.setAmount(book.getAmount() - bookEntry.getAmount());
            bookRepository.save(book);
        }

        cart.clear();

        return true;
    }
}
