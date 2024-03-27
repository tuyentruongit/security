package methodsecurity.methodsecurity.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @RolesAllowed("USER")
    @GetMapping("/profile")
    public String getProfile() {
        return "Xem thông tin cá nhân";
    }

    @RolesAllowed("USER")
    @PutMapping("/profile/create")
    public String updateProfile() {
        return "Cập nhật thông tin cá nhân";
    }
}