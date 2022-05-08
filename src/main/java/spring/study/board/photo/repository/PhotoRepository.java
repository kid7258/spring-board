package spring.study.board.photo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.board.photo.domain.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
