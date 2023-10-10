package com.example.TAsk.controller;

import com.example.TAsk.entity.Department;

import com.example.TAsk.service.impl.DepartmentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    public static final Logger logger= LogManager.getLogger(ClassController.class);
    @Autowired
    DepartmentServiceImpl departmentServiceImpl;

    @PostMapping
    public Department save( @RequestBody Department department){
        logger.info("Added successfully");
        return departmentServiceImpl.save(department);
    }

    @GetMapping
    public List<Department> get(){
        logger.info("Data fetched");
        return departmentServiceImpl.get();
    }

    @DeleteMapping
    public void delete(@PathVariable Long deptId){
        logger.info("Deleted");
        departmentServiceImpl.delete(deptId);
    }
}
