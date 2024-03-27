package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    public String getProfile() {
        return "Xem thông tin cá nhân";
    }

    @PutMapping("/profile/create")
    public String updateProfile() {
        return "Cập nhật thông tin cá nhân";
    }
}