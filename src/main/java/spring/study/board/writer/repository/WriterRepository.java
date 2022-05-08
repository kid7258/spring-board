package spring.study.board.writer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.board.writer.domain.Writer;

public interface WriterRepository extends JpaRepository<Writer, Long> {
}
