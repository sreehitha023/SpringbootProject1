package com.example.TAsk.service.impl;

import com.example.TAsk.entity.Projects;
import com.example.TAsk.repository.ProjectRepository;
import com.example.TAsk.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Projects save(Projects projects){
        return projectRepository.save(projects);
    }

    public List<Projects> get(){
        return projectRepository.findAll();
    }

    public void delete(Long projectId){
        projectRepository.deleteById(projectId);
    }
}
