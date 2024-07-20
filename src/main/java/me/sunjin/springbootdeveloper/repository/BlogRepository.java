package me.sunjin.springbootdeveloper.repository;

import me.sunjin.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Article, Long> {
}

/*
Repository
데이터베이스에 접근하기 위한 객체이다.

Repository는 자바 객체를 테이블에 매핑 할 수 있고 이는 매핑 레벨이 객체 수준
DAO는 SQL에 대한 매핑이기 때문에 매핑 레벨이 SQL 수준
 */