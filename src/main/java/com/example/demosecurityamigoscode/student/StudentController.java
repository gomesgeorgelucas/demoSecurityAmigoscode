package com.example.demosecurityamigoscode.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    static final List<Student> STUDENTS = Arrays.asList(
            Student.builder()
                    .studentId(1)
                    .studentName("Jame Bond")
                    .build(),
            Student.builder()
                    .studentId(2)
                    .studentName("Maria Jones")
                    .build(),
            Student.builder()
                    .studentId(3)
                    .studentName("Anna Smith")
                    .build()
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exists"));
    }
}
