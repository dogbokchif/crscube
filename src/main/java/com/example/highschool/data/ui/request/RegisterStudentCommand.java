package com.example.highschool.data.ui.request;

import lombok.Data;

@Data
public class RegisterStudentCommand {
    private String studentCode;
    private String name;
}
