package com.example.demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Secured({"ROLE_ADMIN","ROLE_SALE","ROLE_AUTHOR"})
    @GetMapping()
    public String getBlog() {
        return "Lấy danh sách các Blog";
    }

    @Secured({"ROLE_ADMIN","ROLE_SALE","ROLE_AUTHOR"})
    @PostMapping("/create")
    public String createBlog() {
        return "Tạo mới Blog";
    }

    @RolesAllowed({"ADMIN","SALE","AUTHOR"})
    @PutMapping("/update/{id}")
    public String updateBlog(@PathVariable("id") Long id) {
        return "Cập nhật thông tin Blog với ID: " + id;
    }

    @RolesAllowed({"ADMIN","SALE","AUTHOR"})
    @DeleteMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id) {
        return "Xoá Blog với ID: " + id;
    }

}
