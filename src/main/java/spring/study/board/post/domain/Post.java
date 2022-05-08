package spring.study.board.post.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import spring.study.board.photo.domain.Photo;
import spring.study.board.writer.domain.Writer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;

    @OneToMany(mappedBy = "post")
    private List<Photo> photos = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public Post(String title, String content, Writer writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void updatePhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
