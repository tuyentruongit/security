package com.example.demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @RolesAllowed("USER")
    @GetMapping("")
    public String getUsers() {
        return "Lấy danh sách người dùng";
    }

    @RolesAllowed("USER")
    @PostMapping("/create")
    public String createUser() {
        return "Tạo mới người dùng";
    }

    @RolesAllowed("USER")
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id) {
        return "Cập nhật thông tin người dùng với ID: " + id;
    }

}
