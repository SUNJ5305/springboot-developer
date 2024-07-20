package me.sunjin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sunjin.springbootdeveloper.domain.User;
import me.sunjin.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException((email)));
    }
}
