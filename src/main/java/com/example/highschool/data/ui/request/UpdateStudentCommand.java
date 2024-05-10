package com.example.highschool.data.ui.request;

import lombok.Data;

@Data
public class UpdateStudentCommand {
    private Long idx;
    private String studentCode;
    private String name;
}
