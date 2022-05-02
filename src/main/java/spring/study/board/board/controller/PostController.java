package spring.study.board.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.study.board.board.controller.request.PostCreatedRequest;
import spring.study.board.board.service.PostService;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public void createPost(@RequestBody PostCreatedRequest request) throws Exception {
        postService.createPost(request);
    }
}
