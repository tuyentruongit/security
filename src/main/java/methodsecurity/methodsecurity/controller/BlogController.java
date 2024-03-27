package methodsecurity.methodsecurity.controller;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @GetMapping()
    public String getBlog() {
        return "Lấy danh sách các Blog";
    }

    @PostMapping("/create")
    public String createBlog() {
        return "Tạo mới Blog";
    }

    @PutMapping("/update/{id}")
    public String updateBlog(@PathVariable("id") Long id) {
        return "Cập nhật thông tin Blog với ID: " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id) {
        return "Xoá Blog với ID: " + id;
    }
}
