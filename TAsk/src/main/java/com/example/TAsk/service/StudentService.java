package com.example.TAsk.service;

import com.example.TAsk.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);
    List<Student> get ();
    Optional<Student> get(Long studentId);
    void delete (Long studentId);
    Student update(Long studentId , Student updatedStudent);
}
