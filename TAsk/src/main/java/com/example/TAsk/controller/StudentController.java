package com.example.TAsk.controller;

import com.example.TAsk.entity.Student;
import com.example.TAsk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public Student save(@Valid @RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping
    public List<Student> get(){
        return studentService.get();
    }

    @DeleteMapping
    public void delete(@PathVariable Long student_id){
        studentService.delete(student_id);
    }

    @PutMapping
    public Student update(@PathVariable Long student_id, @RequestBody Student student) {
        return studentService.update(student_id, student);
    }
}
