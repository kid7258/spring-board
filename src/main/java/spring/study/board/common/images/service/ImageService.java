package spring.study.board.common.images.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {
    @Value("${file.dir}")
    private String directoryPath;

    public List<String> uploadImages(List<MultipartFile> files) throws IOException {
        List<String> paths = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = createFileName(file.getOriginalFilename());
            Path path = Paths.get(directoryPath + fileName);
            file.transferTo(path);
            paths.add(path.toString());
        }

        return paths;
    }

    private String createFileName(String fileName) {
        return UUID.randomUUID() + extractExt(fileName);
    }

    private String extractExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }
}
