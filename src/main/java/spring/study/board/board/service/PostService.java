package spring.study.board.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.study.board.board.controller.request.PostCreatedRequest;
import spring.study.board.board.domain.Post;
import spring.study.board.board.repository.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final WriterService writerService;

    public void createPost(PostCreatedRequest request) throws Exception {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writer(writerService.getWriter(request.getWriterId()).orElseThrow(
                        () -> new Exception("writer not found"))
                ).build();

        postRepository.save(post);
    }
}
