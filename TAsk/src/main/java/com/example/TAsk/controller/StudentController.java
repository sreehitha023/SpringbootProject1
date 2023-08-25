package com.example.TAsk.controller;

import com.example.TAsk.entity.Student;
import com.example.TAsk.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping
    public Student save(@Valid @RequestBody Student student)
    {
        logger.info("Added Successfully");
        return studentServiceImpl.save(student);
    }


    //@Cacheable(cacheNames = "student")
    @GetMapping
    public List<Student> get(){
        logger.info("Data Fetched");
        return studentServiceImpl.get();
    }

    @GetMapping("/{student_id}")
    public Optional<Student> get(@PathVariable Long student_id)
    {
        logger.info("FETCHED");
       return studentServiceImpl.get(student_id);
    }

    //@CacheEvict(cacheNames = "student",key = "#student_id")
    @DeleteMapping
    public void delete(@PathVariable Long student_id){
        logger.info("Deleted");
        studentServiceImpl.delete(student_id);
    }

    //@CachePut(cacheNames = "student", key = "#student_id + '_' + #updatedStudent")
    @PutMapping
    public Student update(@PathVariable Long student_id, @RequestBody Student student) {
        logger.info("Updated");
        return studentServiceImpl.update(student_id, student);
    }
}
