package me.sunjin.springbootdeveloper.repository;


import me.sunjin.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//page 251
/*
    - 메소드 이름으로 쿼리 생성
    - @Query 어노테이션을 사용하여 레포지토리 인터페이스에 쿼리 직접 정의
    - https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserid(String username);
}