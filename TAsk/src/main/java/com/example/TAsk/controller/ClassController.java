package com.example.TAsk.controller;

import com.example.TAsk.entity.Class;
import com.example.TAsk.service.impl.ClassServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    public static final Logger logger = LoggerFactory.getLogger(ClassController.class);
    @Autowired
    ClassServiceImpl classServiceImpl;

    @PostMapping
    public Class save( @RequestBody Class eclass){
        logger.info("success");
       return classServiceImpl.save(eclass);
    }

    @GetMapping
    public List<Class> get(){
        logger.info("fetched successfully");
        return classServiceImpl.get();
    }

    @DeleteMapping
    public void delete(@PathVariable Long class_id){
        logger.info("Deleted Successfully");
        classServiceImpl.delete(class_id);
    }
}
