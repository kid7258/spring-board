package spring.study.board.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.board.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
