package com.example.highschool.global.security;

import com.example.highschool.domain.AccessPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class SecurityConfig {
    @Bean
    public AccessPoint accessPoint() {
        AccessPoint path = new AccessPoint();

        path.add("/v1/student/register", List.of("teacher"));
        path.add("/v1/student/get", List.of("student", "teacher"));
        path.add("/v1/student/update", List.of("teacher"));
        path.add("/v1/student/delete", List.of("teacher"));

        return path;
    }
}