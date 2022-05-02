package spring.study.board.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.board.board.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
