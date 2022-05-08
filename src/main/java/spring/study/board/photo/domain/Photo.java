package spring.study.board.photo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import spring.study.board.post.domain.Post;
import spring.study.board.post.enums.ImageStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Photo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private ImageStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public Photo(Post post, String imageUrl) {
        this.post = post;
        this.imageUrl = imageUrl;
        this.status = ImageStatus.PUBLISHED;
    }
}
