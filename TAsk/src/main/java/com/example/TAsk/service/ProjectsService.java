package com.example.TAsk.service;

import com.example.TAsk.entity.Projects;
import com.example.TAsk.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {
    @Autowired
    ProjectRepository projectRepository;

    public Projects save(Projects projects){
        return projectRepository.save(projects);
    }

    public List<Projects> get(){
        return projectRepository.findAll();
    }

    public void delete(Long project_id){
        projectRepository.deleteById(project_id);
    }
}
