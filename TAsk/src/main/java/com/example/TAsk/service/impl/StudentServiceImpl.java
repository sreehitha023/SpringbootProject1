package com.example.TAsk.service.impl;

import com.example.TAsk.entity.Student;
import com.example.TAsk.exception.InvalidRequestException;
import com.example.TAsk.repository.StudentRepository;
import com.example.TAsk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student)
    {
        if (student.getStudentName() == null || student.getStudentName().isEmpty()) {
            throw new InvalidRequestException("Student name cannot be empty");

        } else {
            return studentRepository.save(student);
        }
    }


    @Override
    @Cacheable(cacheNames = "student")
    public List<Student> get ()
        {
            return studentRepository.findAll();
        }

        @Override
        @Cacheable(cacheNames = "student",key = "#studentId")
        public Optional<Student> get(Long studentId)
        {
        return studentRepository.findById(studentId);
        }
       @Override
       @CacheEvict(cacheNames = "student" , key = "#studentId")
       public void delete (Long studentId)
        {
            studentRepository.deleteById(studentId);
        }


    @Override
    @CachePut(cacheNames = "student", key = "#studentId + '_' + #updatedStudent")
    public Student update(Long studentId , Student updatedStudent)
    {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student= optionalStudent.get();
            student.setStudentName(updatedStudent.getStudentName());
            student.setStudentRollNumber(updatedStudent.getStudentRollNumber());
            return studentRepository.save(student);
        }
        return null;
    }
}
