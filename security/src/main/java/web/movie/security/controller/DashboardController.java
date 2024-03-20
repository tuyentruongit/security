package web.movie.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboard(){
        return "Đã truy cập được trang dashboard";
    }
}
