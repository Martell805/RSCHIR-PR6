package com.example.rschirpr5.controller;

import com.example.rschirpr5.model.Book;
import com.example.rschirpr5.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public Book getBook(@RequestParam Integer id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @GetMapping("all")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PatchMapping
    public Book changeBook(@RequestBody Book book) {
        bookRepository.findById(book.getId()).orElseThrow();

        return bookRepository.save(book);
    }

    @DeleteMapping
    public Book deleteBook(@RequestParam Integer id) {
        Book book = bookRepository.findById(id).orElseThrow();

        bookRepository.deleteById(id);

        return book;
    }
}
