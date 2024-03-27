package com.example.demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/brands")
public class BrandController {
    @RolesAllowed({"ADMIN","SAle"})
    @GetMapping()
    public String getBrand() {
        return "Lấy danh sách các brand";
    }

    @RolesAllowed({"ADMIN","SAle"})
    @PostMapping("/create")
    public String createBrand() {
        return "Tạo mới brand";
    }

    @RolesAllowed({"ADMIN","SAle"})
    @PutMapping("/update/{id}")
    public String updateBrand(@PathVariable("id") Long id) {
        return "Cập nhật thông tin brand với ID: " + id;
    }

    @RolesAllowed({"ADMIN","SAle"})
    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id) {
        return "Xoá brand với ID: " + id;
    }
}
