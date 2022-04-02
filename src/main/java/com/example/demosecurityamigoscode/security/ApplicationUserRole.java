package com.example.demosecurityamigoscode.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

import static com.example.demosecurityamigoscode.security.ApplicationUserPermission.*;

@Getter
@AllArgsConstructor
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    final Set<ApplicationUserPermission> permissions;
}
