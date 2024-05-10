package com.example.highschool.service;

import com.example.highschool.data.ui.request.RegisterStudentCommand;
import com.example.highschool.data.ui.request.UpdateStudentCommand;
import com.example.highschool.domain.Student;

public interface StudentService {
    public String register(RegisterStudentCommand student);
    public Student get(String studentCode);
    public String update(UpdateStudentCommand student);
    public String delete(Long idx);
}
