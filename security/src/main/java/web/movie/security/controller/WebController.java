package web.movie.security.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.movie.security.security.AuthenticationFacade;
import web.movie.security.security.IAuthenticationFacade;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class WebController  {
    private final IAuthenticationFacade iAuthenticationFacade;
    @GetMapping("/")// ai cũng có thể truy câập
    public String getHome(){
        return "Home Page";
    }
    @GetMapping("/user")// role user mới có thể truy cập
    public String getUser(){
        return "Home User";
    }
    @GetMapping("/admin")// role admin mới có thể truy cập
    public String getAdmin(){
        return "Home Admin";
    }
    @GetMapping("/infor")
    public ResponseEntity<?> getInfor(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }
    @GetMapping("/infor1")
    public ResponseEntity<?> getInfor1(Principal principal){
        return ResponseEntity.ok(principal);
    }

    @GetMapping("/infor2")
    public ResponseEntity<?> getInfor2(Authentication authentication){
        return ResponseEntity.ok(authentication);
    }
    @GetMapping("/infor3")
    public ResponseEntity<?> getInfor3(HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(httpServletRequest.getUserPrincipal());
    }
    @GetMapping("/infor4")
    public ResponseEntity<?> getInfor4(){
        Authentication authentication = iAuthenticationFacade.getAuthentication();
        return ResponseEntity.ok(authentication);
    }

//    @GetMapping("/")// ai cũng có thể truy câập
//    public String getHome(){
//        return "Trang chủ";
//    }
//    @GetMapping("/user")
//    public String getUser(){
//        return "Đã truy cập được trang user";
//    }
//
//    @GetMapping("/category")
//    public String getCategory(){
//        return "Đã truy cập được trang category";
//    }
//    @GetMapping("/products")
//    public String getProducts(){
//        return "Đã truy cập được trang products";
//    }
//    @GetMapping("/brand")
//    public String getBrand(){
//        return "Đã truy cập được trang brand";
//    }
//    @GetMapping("/order")
//    public String getOrder(){
//        return "Đã truy cập được trang order";
//    }
//    @GetMapping("/blog")
//    public String getBlog(){
//        return "Đã truy cập được trang blog";
//    }





}
