package com.example.TAsk.controller;

import com.example.TAsk.entity.Class;
import com.example.TAsk.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    public static final Logger logger = LoggerFactory.getLogger(ClassController.class);
    @Autowired
    ClassService classService;

    @PostMapping
    public Class save( @RequestBody Class eclass){
        logger.info("success");
       return classService.save(eclass);
    }

    @GetMapping
    public List<Class> get(){
        logger.info("fetched successfully");
        return classService.get();
    }

    @DeleteMapping
    public void delete(@PathVariable Long class_id){
        logger.info("Deleted Successfully");
        classService.delete(class_id);
    }
}
