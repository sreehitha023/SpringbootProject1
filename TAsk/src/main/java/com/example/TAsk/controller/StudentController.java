package com.example.TAsk.controller;

import com.example.TAsk.entity.Student;
import com.example.TAsk.service.impl.StudentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    public static final Logger logger = LogManager.getLogger(StudentController.class);
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping
    public Student save( @RequestBody @Valid Student student)
    {
        logger.info("ADDED");
        return studentServiceImpl.save(student);
    }

    @GetMapping
    public List<Student> get(){
        logger.info("Data Fetched");
        return studentServiceImpl.get();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> get(@PathVariable Long studentId)
    {
        logger.info("FETCHED");
       return studentServiceImpl.get(studentId);
    }

    @DeleteMapping
    public void delete(@PathVariable Long studentId){
        logger.info("Deleted");
        studentServiceImpl.delete(studentId);
    }

    @PutMapping
    public Student update(@PathVariable Long studentId, @RequestBody Student student) {
        logger.info("Updated");
        return studentServiceImpl.update(studentId, student);
    }
}
