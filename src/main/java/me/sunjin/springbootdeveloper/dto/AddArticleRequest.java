package me.sunjin.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sunjin.springbootdeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    // toEntity() - 빌더 패턴을 사용해 DTO를 엔티티로 만들어주는 메서드
    // "엔티티(Entity)" 주로 데이터베이스의 테이블을 나타내는 클래스
    public Article toEntity() { // 생성자를 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}

/*
DTO(Data Transfer Object, 데이터 전송 객체)란 프로세스 간에 데이터를 전달하는 객체를 의미
뷰에서 컨트롤러로 넘어오는 데이터를 담거나, 컨트롤러에서 서비스로 넘기는 데이터를 담거나 할 때 사용할 수 있다.

@Data 어노테이션은 @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode를 한꺼번에 설정해준다

Request Dto
Response DTO
 */