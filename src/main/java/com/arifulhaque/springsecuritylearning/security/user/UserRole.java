package com.arifulhaque.springsecuritylearning.security.user;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            UserPermission.COURSE_READ,
            UserPermission.COURSE_WRITE,
            UserPermission.STUDENT_READ,
            UserPermission.STUDENT_WRITE
    )),
    ADMIN_TRAINEE(Sets.newHashSet(
            UserPermission.COURSE_READ,
          UserPermission.STUDENT_READ
          ));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return  permissions;
    }
}
