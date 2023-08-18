package com.example.TAsk.service;

import com.example.TAsk.entity.Class;
import com.example.TAsk.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;

    public Class save(Class eclass){
        return classRepository.save(eclass);
    }

    public List<Class> get(){
        return classRepository.findAll();
    }

    public void delete(Long class_id){
        classRepository.deleteById(class_id);
    }
}
