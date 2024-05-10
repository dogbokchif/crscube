package com.example.highschool.data.entity;

import com.example.highschool.data.ui.request.UpdateStudentCommand;
import com.example.highschool.domain.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String name;
    private String studentCode;

    public StudentEntity(String name, String studentCode) {
        this.name = name;
        this.studentCode = studentCode;
    }
    public void update(UpdateStudentCommand command) {
        this.name = command.getName();
        this.studentCode = command.getStudentCode();
    }
    public Student toDomain() {
        return new Student(idx, name, studentCode);
    }
}
