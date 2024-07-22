package me.sunjin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sunjin.springbootdeveloper.domain.User;
import me.sunjin.springbootdeveloper.dto.AddUserRequest;
import me.sunjin.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .userid(dto.getUserid())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
}
