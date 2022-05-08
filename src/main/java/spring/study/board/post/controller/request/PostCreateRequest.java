package spring.study.board.post.controller.request;

import lombok.Getter;

import java.util.List;

@Getter
public class PostCreateRequest {
    private String title;
    private String content;
    private Long writerId;
    private List<String> photos;
}
