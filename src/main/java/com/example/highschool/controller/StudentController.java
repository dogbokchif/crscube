package com.example.highschool.controller;

import com.example.highschool.data.ui.request.RegisterStudentCommand;
import com.example.highschool.data.ui.request.UpdateStudentCommand;
import com.example.highschool.domain.Student;
import com.example.highschool.global.annotation.WebAdapter;
import com.example.highschool.global.util.ResponsePacker;
import com.example.highschool.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter("/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(
            @RequestBody RegisterStudentCommand student
    ) {
        return ResponsePacker.packing(studentService.register(student), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(
            @RequestParam("studentCode") String studentCode
    ) {
        return ResponsePacker.packing(studentService.get(studentCode), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(
            @RequestBody UpdateStudentCommand student
    ) {
        return ResponsePacker.packing(studentService.update(student), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(
            @RequestParam("idx") Long idx
    ) {
        return ResponsePacker.packing(studentService.delete(idx), HttpStatus.OK);
    }
}