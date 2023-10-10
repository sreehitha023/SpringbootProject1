package com.example.TAsk.service;

import com.example.TAsk.entity.Projects;

import java.util.List;

public interface ProjectService {
    Projects save(Projects projects);
    List<Projects> get();
    void delete(Long projectId);
}
