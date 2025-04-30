package com.example.student_service.repository;

import com.example.student_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Student save(Student student);

    ScopedValue<Object> findById(Long id);
}

