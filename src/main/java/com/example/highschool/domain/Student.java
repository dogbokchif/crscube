package com.example.highschool.domain;

import com.example.highschool.data.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Long idx;
    private String name;
    private String schoolNumber;

    public StudentEntity toEntity() {
        return new StudentEntity(idx, name, schoolNumber);
    }
}
