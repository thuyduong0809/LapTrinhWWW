package com.example.buithithuyduong_20034151_lab06.controller;


import com.example.buithithuyduong_20034151_lab06.entity.Book;
import com.example.buithithuyduong_20034151_lab06.repository.BookRepository;
import com.example.buithithuyduong_20034151_lab06.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepo;
    private final CategoryRepository categoryRepo;

    public BookController(BookRepository bookRepo, CategoryRepository categoryRepo) {
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public String listBooks(@RequestParam(required = false) String keyword,
                            @RequestParam(required = false) String category,
                            Model model) {

        List<Book> books;

        if (keyword != null && !keyword.isEmpty()) {
            books = bookRepo.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
        } else if (category != null && !category.isEmpty()) {
            books = bookRepo.findByCategory_Name(category);
        } else {
            books = bookRepo.findAll();
        }

        model.addAttribute("books", books);
        model.addAttribute("categories", categoryRepo.findAll());

        return "books";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepo.findAll());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        bookRepo.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepo.findById(id).orElse(null));
        model.addAttribute("categories", categoryRepo.findAll());
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookRepo.deleteById(id);
        return "redirect:/books";
    }
}