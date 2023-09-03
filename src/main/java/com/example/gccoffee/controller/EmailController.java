package com.example.gccoffee.controller;

import com.example.gccoffee.model.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    @PostMapping("/validateEmail")
    public ResponseEntity<String> validateEmail(@Valid @RequestBody Email email, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("유효하지 않은 이메일 주소입니다");
        }
        return ResponseEntity.ok("유효한 이메일 주소입니다.");
    }
}