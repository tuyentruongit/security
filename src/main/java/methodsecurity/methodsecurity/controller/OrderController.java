package methodsecurity.methodsecurity.controller;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping()
    public String getOrder() {
        return "Lấy danh sách các order";
    }

    @PostMapping("/create")
    public String createOrder() {
        return "Tạo mới order";
    }

    @PutMapping("/update/{id}")
    public String updateOrder(@PathVariable("id") Long id) {
        return "Cập nhật thông tin order với ID: " + id;
    }


}
