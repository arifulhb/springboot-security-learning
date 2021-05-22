package com.arifulhaque.springsecuritylearning.controller;

import com.arifulhaque.springsecuritylearning.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Ariufl"),
            new Student(2, "Tajia"),
            new Student(3, "Arya"),
            new Student(4, "Anamul"),
            new Student(5, "Sami"),
            new Student(6, "Mina"),
            new Student(7, "Mou")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        log.info("getAllStudents = {}", STUDENTS);
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        log.info("register student = {}", student);

    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        log.info("delete studentId = {}", studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, Student student){
        log.info("updating student = {}", student);
    }
}
