package spring.study.board.post.controller.response;

import lombok.Getter;
import spring.study.board.photo.domain.Photo;
import spring.study.board.post.domain.Post;
import spring.study.board.post.enums.ImageStatus;
import spring.study.board.writer.domain.Writer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private WriterResponse writer;
    private List<PhotoResponse> photos;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writer = new WriterResponse(post.getWriter());
        this.photos = PhotoResponse.getPhotos(post.getPhotos());
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }

    @Getter
    public static class WriterResponse {
        private Long id;
        private String name;
        private String profileImageUrl;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public WriterResponse(Writer writer) {
            this.id = writer.getId();
            this.name = writer.getName();
            this.profileImageUrl = writer.getProfileImageUrl();
            this.createdAt = writer.getCreatedAt();
            this.updatedAt = writer.getUpdatedAt();
        }
    }

    @Getter
    public static class PhotoResponse {
        private Long id;
        private String imageUrl;
        private ImageStatus status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public PhotoResponse(Photo photo) {
            this.id = photo.getId();
            this.imageUrl = photo.getImageUrl();
            this.status = photo.getStatus();
            this.createdAt = photo.getCreatedAt();
            this.updatedAt = photo.getUpdatedAt();
        }

        public static List<PhotoResponse> getPhotos(List<Photo> photos) {
            return photos.stream().map(PhotoResponse::new).collect(Collectors.toList());
        }
    }
}
