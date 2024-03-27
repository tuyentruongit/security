package methodsecurity.methodsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/orders")
public class OrderController {
    @PreAuthorize("hasAnyRole('ADMIN','SALE')")
    @GetMapping()
    public String getOrder() {
        return "Lấy danh sách các order";
    }

    @PreAuthorize("hasAnyRole('ADMIN','SALE')")
    @PostMapping("/create")
    public String createOrder() {
        return "Tạo mới order";
    }

    @PreAuthorize("hasAnyRole('ADMIN','SALE')")
    @PutMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") Long id) {
        return "Cập nhật thông tin order với ID: " + id;
    }


}
