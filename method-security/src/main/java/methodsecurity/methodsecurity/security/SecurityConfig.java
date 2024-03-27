package methodsecurity.methodsecurity.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailService customUserDetailService;

    @Bean
    public AuthenticationProvider authenticationProvider (){
        DaoAuthenticationProvider provider  = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(customUserDetailService);
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorization -> {
            authorization.anyRequest().permitAll();
        });
//        // cấu hình đường dẫn truy cập
//        httpSecurity.authorizeHttpRequests(authorization ->{
//            authorization.requestMatchers("/").permitAll();
//            authorization.requestMatchers("/user").hasRole("USER");
//            authorization.requestMatchers("/admin").hasRole("ADMIN");
//            authorization.anyRequest().authenticated();
//        });
//
        // cấu hình form login
        httpSecurity.formLogin(formLogin ->{
            formLogin.loginPage("/login");
            formLogin.loginProcessingUrl("/login-handle");
            formLogin.usernameParameter("name");
            formLogin.passwordParameter("pass");
            formLogin.defaultSuccessUrl("/",true);
            formLogin.permitAll();


        });
        // cấu hình form logout
        httpSecurity.logout(logout ->{
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            logout.clearAuthentication(true);
            logout.logoutSuccessUrl("/");
            logout.permitAll();

        });

        // cấu hình xác thực
        httpSecurity.authenticationProvider(authenticationProvider());


        return httpSecurity.build();
    }
}
