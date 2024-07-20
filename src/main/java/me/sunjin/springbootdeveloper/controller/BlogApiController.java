package me.sunjin.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.sunjin.springbootdeveloper.domain.Article;
import me.sunjin.springbootdeveloper.dto.AddArticleRequest;
import me.sunjin.springbootdeveloper.dto.ArticleResponse;
import me.sunjin.springbootdeveloper.dto.UpdateArticleRequest;
import me.sunjin.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    // GET 요청이 들어오면 글 전체를 조회하는 findAll() 메서드를 호출한 다음
    // 응답용 객체인 ArticleResponse로 파싱해 body에 담아 클라이언트에게 전송
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.ok().body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);

        return ResponseEntity.ok().body(updateArticle);
    }
}

/*
[ @RestController ]
@RestController = @Controller + @ResponseBody
Json 형태로 객체 데이터를 반환
 */
