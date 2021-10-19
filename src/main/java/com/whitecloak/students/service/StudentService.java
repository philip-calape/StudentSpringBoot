package com.whitecloak.students.service;

import com.whitecloak.students.model.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity register(StudentEntity newUser);
    List<StudentEntity> getUsers();
}
