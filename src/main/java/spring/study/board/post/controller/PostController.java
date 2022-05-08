package spring.study.board.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.study.board.post.controller.request.PostCreateRequest;
import spring.study.board.post.controller.response.PostResponse;
import spring.study.board.post.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostResponse create(@RequestBody PostCreateRequest request) throws Exception {
        return new PostResponse(postService.create(request));
    }

    @GetMapping
    public List<PostResponse> getPosts() {
        return postService.getPosts().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }
}
