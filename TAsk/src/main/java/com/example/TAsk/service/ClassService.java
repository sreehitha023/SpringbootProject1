package com.example.TAsk.service;

import com.example.TAsk.entity.Class;

import java.util.List;

public interface ClassService {
    Class save(Class eclass);
    List<Class> get();
    void delete(Long classId);

}
