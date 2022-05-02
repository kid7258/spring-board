package spring.study.board.board.controller.request;

import lombok.Getter;

@Getter
public class PostCreatedRequest {
    private String title;
    private String content;
    private Long writerId;
}
