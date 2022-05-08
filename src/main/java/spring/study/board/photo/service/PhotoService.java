package spring.study.board.photo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.study.board.photo.repository.PhotoRepository;
import spring.study.board.photo.domain.Photo;
import spring.study.board.post.domain.Post;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public List<Photo> create(Post post, List<String> imageUrls) {
        List<Photo> photos = new ArrayList<>();
        for (String imageUrl : imageUrls) {
            photos.add(Photo.builder().post(post).imageUrl(imageUrl).build());
        }

        return photoRepository.saveAll(photos);
    }
}
