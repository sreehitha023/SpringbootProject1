package com.example.TAsk.controller;

import com.example.TAsk.entity.Class;
import com.example.TAsk.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @PostMapping
    public Class save( @RequestBody Class eclass){
       return classService.save(eclass);
    }

    @GetMapping
    public List<Class> get(){
        return classService.get();
    }

    @DeleteMapping
    public void delete(@PathVariable Long class_id){
        classService.delete(class_id);
    }
}
