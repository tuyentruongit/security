package methodsecurity.methodsecurity.controller;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Secured({"ROLE_ADMIN","ROLE_SALE"})
    @GetMapping()
    public String getProduct() {
        return "Lấy danh sách các sản phẩm";
    }

    @Secured({"ROLE_ADMIN","ROLE_SALE"})
    @PostMapping("/create")
    public String createProduct() {
        return "Tạo mới sản phẩm";
    }

    @Secured({"ROLE_ADMIN","ROLE_SALE"})
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id) {
        return "Cập nhật thông tin sản phẩm với ID: " + id;
    }

    @Secured({"ROLE_ADMIN","ROLE_SALE"})
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        return "Xoá sản phẩm với ID: " + id;
    }
}
