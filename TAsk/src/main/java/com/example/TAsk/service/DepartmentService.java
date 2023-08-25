package com.example.TAsk.service;

import com.example.TAsk.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);
    List<Department> get();
    void delete(Long dept_id);
}
