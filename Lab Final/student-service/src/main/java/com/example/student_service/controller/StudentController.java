package com.example.student_service.controller;



import com.example.student_service.entity.Student;
import com.example.student_service.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return repo.save(student);
    }

    @GetMapping
    public List<Student> list() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
