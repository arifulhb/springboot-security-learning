package com.arifulhaque.springsecuritylearning.security.user;

import com.google.common.collect.Sets;
import java.util.Set;

public enum UserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            UserPermission.COURSE_READ,
            UserPermission.COURSE_WRITE,
            UserPermission.STUDENT_READ,
            UserPermission.STUDENT_WRITE
    ));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
