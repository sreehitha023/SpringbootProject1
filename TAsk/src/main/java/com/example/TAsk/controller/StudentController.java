package com.example.TAsk.controller;

import com.example.TAsk.entity.Student;
import com.example.TAsk.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    @PostMapping
    public Student save(@Valid @RequestBody Student student)
    {
        logger.info("Added Successfully");
        return studentService.save(student);
    }

    @GetMapping
    public List<Student> get(){
        logger.info("Data Fetched");
        return studentService.get();
    }

    @DeleteMapping
    public void delete(@PathVariable Long student_id){
        logger.info("Deleted");
        studentService.delete(student_id);
    }

    @PutMapping
    public Student update(@PathVariable Long student_id, @RequestBody Student student) {
        logger.info("Updated");
        return studentService.update(student_id, student);
    }
}
