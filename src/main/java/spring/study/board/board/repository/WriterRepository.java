package spring.study.board.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.board.board.domain.Writer;

public interface WriterRepository extends JpaRepository<Writer, Long> {
}
