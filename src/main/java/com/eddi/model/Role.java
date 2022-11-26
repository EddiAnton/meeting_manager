package com.eddi.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;
import com.google.common.collect.ImmutableSet;

public enum Role {

    USER(ImmutableSet.of(Permission.EMPLOYEE_READ,
            Permission.DEPARTMENT_READ,
            Permission.MEETING_READ,
            Permission.MEETING_CREATE,
            Permission.REPORT_READ,
            Permission.REPORT_CREATE)),
    ADMIN(ImmutableSet.of(Permission.EMPLOYEE_READ,
            Permission.EMPLOYEE_CREATE,
            Permission.DEPARTMENT_READ,
            Permission.DEPARTMENT_CREATE,
            Permission.MEETING_READ,
            Permission.MEETING_CREATE,
            Permission.REPORT_READ,
            Permission.REPORT_CREATE,
            Permission.ADMIN_VIEW));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
