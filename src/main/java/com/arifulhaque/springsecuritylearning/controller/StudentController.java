package com.arifulhaque.springsecuritylearning.controller;

import com.arifulhaque.springsecuritylearning.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Ariufl"),
            new Student(2, "Tajia"),
            new Student(3, "Arya"),
            new Student(4, "Anamul"),
            new Student(5, "Sami"),
            new Student(6, "Mina"),
            new Student(7, "Mou")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(
            @PathVariable("studentId")
            Integer studentId
    ) {
        return STUDENTS
                .stream()
                .filter(student ->  studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist") );
    }
}
