package me.sunjin.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class) // 엔티티의 생성 및 수정 시간을 자동으로 감시하고 기록
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceGeneratorName")
    @SequenceGenerator(
            name="SequenceGeneratorName",
            sequenceName = "kicboardseq", allocationSize = 1
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate // 엔티티가 생성될 때 생성 시간 저장
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @Builder
    public Article(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

/*
Domain(Entity)
실제 DB 테이블과 매핑시키는 클래스이다

@Entity 어노테이션을 사용해 데이터베이스 테이블과 매칭될 클래스임을 나타낸다.
@Builder 어노테이션을 사용해서 객체 생성 시점에 값을 넣어줄 수 있다.
Setter를 여러 군데에서 사용해서 일관성을 보장하지 못하게 사용하는 것보다, Builder 어노테이션을 사용하는 것이 좋아보인다.
 */