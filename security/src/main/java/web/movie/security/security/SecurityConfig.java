package web.movie.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.sql.Struct;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        String[] url = {"/phim-bo/**","/phim-le/**","/phim-chieu-rap/**"};
        String[] urlADmin = {"/dashboard", "/blogs/**","/brands/**","/category/**","/order/**","/products/**","/user/**"};
        String[] urlSale = {"/dashboard","/brands/**","/category/**","/order/**","/products/**"};
        // cấu hình đường dẫn truy cập
        httpSecurity.authorizeHttpRequests(authorization ->{
            /* Bài bập về nha*/

            //C1
//            authorization.requestMatchers(urlADmin).hasRole("ADMIN");
//            authorization.requestMatchers(urlSale).hasRole("SALE");
//            authorization.requestMatchers("/blogs/**").hasAnyRole("SALE","AUTHOR");
//            authorization.requestMatchers("/profile").hasRole("USER");
            //C2
            authorization.requestMatchers("/dashboard").hasAnyRole("ADMIN", "SALE")
                    .requestMatchers("/user", "/create-user", "/update-user", "/delete-user").hasRole("ADMIN")
                    .requestMatchers("/category", "category/create", "/category/update/", "/category/delete/**").hasAnyRole("ADMIN", "SALE")
                    .requestMatchers("/products", "/products/create", "/products/update/", "/products/delete/**").hasAnyRole("ADMIN", "SALE")
                    .requestMatchers("/brands", "/brands/create", "/brands/update/", "/brands/delete/**").hasAnyRole("ADMIN", "SALE")
                    .requestMatchers("/orders", "/orders/create", "/orders/update/").hasAnyRole("ADMIN", "SALE")
                    .requestMatchers("/blogs", "/blogs/create", "/blogs/update/", "/blogs/delete/**").hasAnyRole("ADMIN", "SALE", "AUTHOR")
                    .requestMatchers("/profile", "/profile/create").hasRole("USER");

            /*hết*/



            authorization.requestMatchers("/").permitAll();// nếu như trùng đường dẫn ("/) thì ai cx có thể đi qua
            authorization.requestMatchers("/user").hasRole("USER");;// nếu như đường dẫn (/user) thì cần phải có role user
            authorization.requestMatchers("/admin").hasRole("ADMIN");// nếu như đường dẫn (/admin) thì cần phải có role admin
            authorization.requestMatchers("/css/**","/js/**","/image/**").permitAll(); // với những đường dẫn bắt đầu bằng như trong ngoặc thì không cần xác thực
            authorization.requestMatchers(url).permitAll();// tất cả mọi đường dẫn trong mảng url đều có thể truy cập k cần xác thực
            authorization.requestMatchers("/author").hasAnyRole("ADMIN","USER"); // đường có thể cho nhiều role truy cập vào
            authorization.requestMatchers("GET","/bb/**","/cc/**").hasRole("ADMIN");// các đường dẫn cần có role Admin và phải là phương thức GET
            authorization.requestMatchers("/dd/**","/ee/**").hasAuthority("ROlE_ADMIN");// phải thêm tiền tố trước ADmin
            authorization.anyRequest().authenticated();// tất cả đường dẫn còn lại cần phải xác thực





        });


        // cấu hình form login

        httpSecurity.formLogin(formLogin->{
//            formLogin.loginPage("/login");// có đường dẫn tả về form log in thì sử dụng
            formLogin.defaultSuccessUrl("/",true);// tự động chuyển hướng khi đăng nhập thành công
            formLogin.defaultSuccessUrl("/abc",false);// tự động chuyển hướng khi đăng nhập thất bại
            formLogin.permitAll();// cho phép tât cả mọi người truy cập vào form login

        });


        // cấu hình form logout


        httpSecurity.logout(logout->{
            logout.logoutSuccessUrl("/");// logout thành công sẽ chuyển hướng
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);// hủy session
            logout.clearAuthentication(true);//xóa thông tin đăng nhập
            logout.permitAll();
        });

        return httpSecurity.build();
    }
}
