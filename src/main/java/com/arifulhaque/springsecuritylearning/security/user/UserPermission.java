package com.arifulhaque.springsecuritylearning.security.user;

import lombok.Getter;

public enum UserPermission {

    // roles
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    @Getter
    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }
}
