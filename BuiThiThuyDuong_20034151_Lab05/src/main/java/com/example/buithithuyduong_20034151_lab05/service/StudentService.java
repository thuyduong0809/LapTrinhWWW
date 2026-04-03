package com.example.buithithuyduong_20034151_lab05.service;


import com.example.buithithuyduong_20034151_lab05.entity.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);
    List<Student> findAll();
    Student findById(Integer id);


    List<Student> findByName(String name);
}