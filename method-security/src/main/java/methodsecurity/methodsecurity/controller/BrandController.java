package methodsecurity.methodsecurity.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/brands")
public class BrandController {
    @RolesAllowed({"ADMIN","SALE"})
    @GetMapping()
    public String getBrand() {
        return "Lấy danh sách các brand";
    }

    @RolesAllowed({"ADMIN","SALE"})
    @PostMapping("/create")
    public String createBrand() {
        return "Tạo mới brand";
    }

    @RolesAllowed({"ADMIN","SALE"})
    @PutMapping("/update/{id}")
    public String updateBrand(@PathVariable("id") Long id) {
        return "Cập nhật thông tin brand với ID: " + id;
    }

    @RolesAllowed({"ADMIN","SALE"})
    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id) {
        return "Xoá brand với ID: " + id;
    }
}
