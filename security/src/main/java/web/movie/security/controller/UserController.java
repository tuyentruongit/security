package web.movie.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public String getUsers() {
        return "Lấy danh sách người dùng";
    }

    @PostMapping("/create")
    public String createUser() {
        return "Tạo mới người dùng";
    }
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id) {
        return "Cập nhật thông tin người dùng với ID: " + id;
    }

}
