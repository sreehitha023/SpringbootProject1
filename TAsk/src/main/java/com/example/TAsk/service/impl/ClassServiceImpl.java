package com.example.TAsk.service.impl;

import com.example.TAsk.entity.Class;
import com.example.TAsk.repository.ClassRepository;
import com.example.TAsk.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(value = {"local","dev","prod"})
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;

    public Class save(Class eclass){
        return classRepository.save(eclass);
    }

    public List<Class> get(){
        return classRepository.findAll();
    }

    public void delete(Long classId){
        classRepository.deleteById(classId);
    }
}
