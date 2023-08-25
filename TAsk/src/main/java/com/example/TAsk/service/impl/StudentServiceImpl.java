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
        if (student.getStudent_name() == null || student.getStudent_name().isEmpty()) {
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
        @Cacheable(cacheNames = "student",key = "#student_id")
        public Optional<Student> get(Long student_id)
        {
        return studentRepository.findById(student_id);
        }
       @Override
       @CacheEvict(cacheNames = "student" , key = "#student_id")
       public void delete (Long student_id)
        {
            studentRepository.deleteById(student_id);
        }


    @Override
    @CachePut(cacheNames = "student", key = "#student_id + '_' + #updatedStudent")
    public Student update(Long student_id , Student updatedStudent)
    {
        Optional<Student> optionalStudent = studentRepository.findById(student_id);
        if (optionalStudent.isPresent()) {
            Student student= optionalStudent.get();
            student.setStudent_name(updatedStudent.getStudent_name());
            student.setStudent_rollNumber(updatedStudent.getStudent_rollNumber());
            return studentRepository.save(student);
        }
        return null;
    }
}
