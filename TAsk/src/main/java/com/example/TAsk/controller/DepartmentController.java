package com.example.TAsk.controller;

import com.example.TAsk.entity.Department;

import com.example.TAsk.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public Department save( @RequestBody Department department){
        return departmentService.save(department);
    }

    @GetMapping
    public List<Department> get(){
        return departmentService.get();
    }

    @DeleteMapping
    public void delete(@PathVariable Long dept_id){
        departmentService.delete(dept_id);
    }
}
