package me.sunjin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sunjin.springbootdeveloper.domain.Article;
import me.sunjin.springbootdeveloper.domain.User;
import me.sunjin.springbootdeveloper.dto.AddUserRequest;
import me.sunjin.springbootdeveloper.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .userid(dto.getUserid())
                .password(dto.getPassword())
                .build()).getId();
    }

    public User findByUserid(String userid) {
        return userRepository.findByUserid(userid)
                .orElseThrow(() -> new IllegalArgumentException(("not found: ") + userid));
    }
}
