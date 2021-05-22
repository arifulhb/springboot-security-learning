package com.arifulhaque.springsecuritylearning.model;

import lombok.Getter;

@Getter
public class Student {

    private final Integer studentId;
    private final String name;

    public Student(Integer studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
}
