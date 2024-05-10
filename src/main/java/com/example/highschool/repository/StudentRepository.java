package com.example.highschool.repository;

import com.example.highschool.data.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    public StudentEntity findByStudentCode(String code);
    public StudentEntity findByIdx(Long idx);
    public void deleteByIdx(Long idx);
}
