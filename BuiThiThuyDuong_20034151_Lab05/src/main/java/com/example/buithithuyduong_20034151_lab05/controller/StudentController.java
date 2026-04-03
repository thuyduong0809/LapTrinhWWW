package com.example.buithithuyduong_20034151_lab05.controller;

import com.example.buithithuyduong_20034151_lab05.entity.Student;
import com.example.buithithuyduong_20034151_lab05.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id, Model model) {
        Student student = service.findById(id);
        model.addAttribute("student", student);
        return "detail"; // tạo file detail.html
    }
    // Hiển thị danh sách
    @GetMapping
    public String list(@RequestParam(required = false) Integer id, Model model) {

        if (id != null) {
            Student s = service.findById(id);

            if (s != null) {
                model.addAttribute("students", List.of(s)); // trả về 1 phần tử
            } else {
                model.addAttribute("students", List.of()); // không tìm thấy
            }

        } else {
            model.addAttribute("students", service.findAll());
        }

        return "students";
    }

    // Form thêm
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    // Lưu
    @PostMapping("/save")
    public String save(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students";
    }
}