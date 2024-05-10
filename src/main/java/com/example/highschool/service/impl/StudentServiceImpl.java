package com.example.highschool.service.impl;

import com.example.highschool.data.entity.StudentEntity;
import com.example.highschool.data.ui.request.RegisterStudentCommand;
import com.example.highschool.data.ui.request.UpdateStudentCommand;
import com.example.highschool.domain.Student;
import com.example.highschool.repository.StudentRepository;
import com.example.highschool.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public String register(RegisterStudentCommand student) {
        studentRepository.save(new StudentEntity(student.getName(), student.getStudentCode()));
        return "success";
    }

    @Override
    public Student get(String studentCode) {
        return studentRepository.findByStudentCode(studentCode).toDomain();
    }

    @Override
    public String update(UpdateStudentCommand student) {
        StudentEntity entity = studentRepository.findByIdx(student.getIdx());
        entity.update(student);
        return "success";
    }

    @Override
    public String delete(Long idx) {
        studentRepository.deleteByIdx(idx);
        return "success";
    }
}
