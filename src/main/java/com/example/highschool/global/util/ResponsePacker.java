package com.example.highschool.global.util;

import com.example.highschool.global.annotation.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Util
public class ResponsePacker {
    static public <T> ResponseEntity<T> packing(T body, HttpStatus status) {
        return new ResponseEntity<>(body, status);
    }
}
