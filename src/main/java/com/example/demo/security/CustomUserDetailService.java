package com.example.demo.security;

import com.example.demo.model.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private List<User> userList ;

    public CustomUserDetailService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        userList = new ArrayList<>();
        userList.add(new User(1,"tuyen",passwordEncoder.encode("123"),List.of("USER","ADMIN")));
        userList.add(new User(2,"hai",passwordEncoder.encode("123"),List.of("USER")));
        userList.add(new User(3,"tu",passwordEncoder.encode("123"),List.of("AUTHOR")));
        userList.add(new User(4,"tung",passwordEncoder.encode("123"),List.of("SALE")));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userList.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserDetail(user);
    }
}
