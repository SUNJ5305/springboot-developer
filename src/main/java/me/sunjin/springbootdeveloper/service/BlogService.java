package me.sunjin.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sunjin.springbootdeveloper.domain.Article;
import me.sunjin.springbootdeveloper.dto.AddArticleRequest;
import me.sunjin.springbootdeveloper.dto.UpdateArticleRequest;
import me.sunjin.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor    // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // ID를 받아 엔티티를 조회하고 없으면 IllegalArgumentException 예외 발생
    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(("not found: ") + id));
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional  // 매칭한 메서드를 하나의 트랜잭션으로 묶는역할
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(("not found: ") + id));
                // orElseThrow => 해당 item이 없다면 예외, 있다면 return

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
