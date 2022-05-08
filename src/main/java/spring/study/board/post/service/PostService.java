package spring.study.board.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.study.board.photo.domain.Photo;
import spring.study.board.photo.service.PhotoService;
import spring.study.board.post.controller.request.PostCreateRequest;
import spring.study.board.post.domain.Post;
import spring.study.board.post.repository.PostRepository;
import spring.study.board.writer.service.WriterService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final WriterService writerService;
    private final PhotoService photoService;

    public Post create(PostCreateRequest request) throws Exception {
        Post post = postRepository.save(Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writer(writerService.getWriter(request.getWriterId()).orElseThrow(
                        () -> new Exception("writer not found"))
                ).build());

        post.updatePhotos(photoService.create(post, request.getPhotos()));

        return post;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
