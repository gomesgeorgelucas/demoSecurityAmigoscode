package com.example.demosecurityamigoscode.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Student {
    final Integer studentId;
    final String studentName;
}
