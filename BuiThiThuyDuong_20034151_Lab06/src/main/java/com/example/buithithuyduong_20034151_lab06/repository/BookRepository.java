package com.example.buithithuyduong_20034151_lab06.repository;

import com.example.buithithuyduong_20034151_lab06.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author);

    List<Book> findByCategory_Name(String name);
}