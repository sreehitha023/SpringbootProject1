package com.example.TAsk.service;

import com.example.TAsk.entity.Student;
import com.example.TAsk.exception.InvalidRequestException;
import com.example.TAsk.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
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


        public List<Student> get ()
        {
            return studentRepository.findAll();
        }

        public void delete (Long student_id)
        {
            studentRepository.deleteById(student_id);
        }

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
