package web.movie.security.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @GetMapping()
    public String getCategories() {
        return "Lấy danh sách các danh mục";
    }

    @PostMapping("/create")
    public String createCategory() {
        return "Tạo mới danh mục";
    }

    @PutMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long id) {
        return "Cập nhật thông tin danh mục với ID: " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        return "Xoá danh mục với ID: " + id;
    }
}

