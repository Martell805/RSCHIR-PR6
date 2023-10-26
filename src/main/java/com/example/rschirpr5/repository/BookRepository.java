package com.example.rschirpr5.repository;

import com.example.rschirpr5.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}