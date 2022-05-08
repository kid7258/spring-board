package spring.study.board.writer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.study.board.writer.domain.Writer;
import spring.study.board.writer.repository.WriterRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WriterService {
    private final WriterRepository writerRepository;

    public Optional<Writer> getWriter(Long writerId) {
        return writerRepository.findById(writerId);
    }
}
