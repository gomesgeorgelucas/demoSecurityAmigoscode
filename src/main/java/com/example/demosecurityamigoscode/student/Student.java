package com.example.demosecurityamigoscode.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Student {
    final Integer studentId;
    final String studentName;
}
