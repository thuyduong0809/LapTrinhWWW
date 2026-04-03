package com.example.buithithuyduong_20034151_lab05.service;

import com.example.buithithuyduong_20034151_lab05.entity.Student;
import com.example.buithithuyduong_20034151_lab05.repository.StudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    // Constructor Injection
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}