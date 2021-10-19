package com.whitecloak.students.repository;

import com.whitecloak.students.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity save(StudentEntity entity);

    List<StudentEntity> findAll();
}
