package web.movie.security.controller;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping()
    public String getProduct() {
        return "Lấy danh sách các sản phẩm";
    }

    @PostMapping("/create")
    public String createProduct() {
        return "Tạo mới sản phẩm";
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id) {
        return "Cập nhật thông tin sản phẩm với ID: " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        return "Xoá sản phẩm với ID: " + id;
    }
}
