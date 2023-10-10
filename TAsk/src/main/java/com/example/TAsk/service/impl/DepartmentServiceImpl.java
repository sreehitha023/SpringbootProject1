package com.example.TAsk.service.impl;

import com.example.TAsk.entity.Department;
import com.example.TAsk.repository.DepartmentRepository;
import com.example.TAsk.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> get(){
        return departmentRepository.findAll();
    }

    public void delete(Long deptId){
        departmentRepository.deleteById(deptId);
    }
}
