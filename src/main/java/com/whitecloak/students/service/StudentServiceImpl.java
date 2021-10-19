package com.whitecloak.students.service;

import com.whitecloak.students.model.StudentEntity;
import com.whitecloak.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity register(StudentEntity newUser) {
        StudentEntity newStudentEntity = studentRepository.save(newUser);
        return newStudentEntity;
    }

    @Override
    public List<StudentEntity> getUsers() {
        return studentRepository.findAll();
    }
}
