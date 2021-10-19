package com.whitecloak.students.controller;

import com.whitecloak.students.model.StudentEntity;
import com.whitecloak.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentEntity register(@RequestBody StudentEntity newUser) {
        return studentService.register(newUser);
    }

    @GetMapping
    public List<StudentEntity> getUsers() {
        return studentService.getUsers();
    }

}
