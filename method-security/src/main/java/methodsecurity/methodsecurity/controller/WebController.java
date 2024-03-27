package methodsecurity.methodsecurity.controller;
import jakarta.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String getHome (){
        return "index";
    }
    @Secured("ROLE_USER")
//   @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String getUser (){
        return "user";
    }
    @RolesAllowed("ADMIN")
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdmin (){
        return "admin";
    }


    @GetMapping("/login")
    public String getLogin (){
        return "login";
    }

//    @GetMapping("infor")
//    public ResponseEntity<?> infor(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return ResponseEntity.ok(authentication);
//    }
}
