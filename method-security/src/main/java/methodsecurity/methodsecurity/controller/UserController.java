package methodsecurity.methodsecurity.controller;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
public class UserController {
    @Secured({"ROLE_ADMIN"})
    @GetMapping("")
    public String getUsers() {
        return "Lấy danh sách người dùng";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/create")
    public String createUser() {
        return "Tạo mới người dùng";
    }

    @RolesAllowed({"ADMIN"})
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id) {
        return "Cập nhật thông tin người dùng với ID: " + id;
    }


}
