package methodsecurity.methodsecurity.controller;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/brands")
public class BrandController {
    @GetMapping()
    public String getBrand() {
        return "Lấy danh sách các brand";
    }

    @PostMapping("/create")
    public String createBrand() {
        return "Tạo mới brand";
    }

    @PutMapping("/update/{id}")
    public String updateBrand(@PathVariable("id") Long id) {
        return "Cập nhật thông tin brand với ID: " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id) {
        return "Xoá brand với ID: " + id;
    }
}
