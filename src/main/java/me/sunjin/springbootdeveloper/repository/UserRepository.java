package me.sunjin.springbootdeveloper.repository;


import me.sunjin.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//page 251
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}