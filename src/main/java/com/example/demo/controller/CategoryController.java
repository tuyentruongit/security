package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @PreAuthorize("hasAnyRole('ADMIN','SALE')")
    @GetMapping()
    public String getCategories() {
        return "Lấy danh sách các danh mục";
    }

    @PreAuthorize("hasAnyRole('ADMIN','SALE')")
    @PostMapping("/create")
    public String createCategory() {
        return "Tạo mới danh mục";
    }

    @PreAuthorize("hasAnyRole('ADMIN','SALE')")
    @PutMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long id) {
        return "Cập nhật thông tin danh mục với ID: " + id;
    }

    @PreAuthorize("hasAnyRole('ADMIN','SALE')")
    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        return "Xoá danh mục với ID: " + id;
    }
}

