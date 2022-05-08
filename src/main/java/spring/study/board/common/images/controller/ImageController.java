package spring.study.board.common.images.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.study.board.common.images.controller.request.ImageUploadRequest;
import spring.study.board.common.images.service.ImageService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ResponseEntity upload(@RequestPart List<MultipartFile> files) throws IOException {
        List<String> paths = imageService.uploadImages(files);
        return new ResponseEntity(paths, HttpStatus.OK);
    }

    // 다른 request와 함께 받으려면, Body 값에 form-data로 request를 키로 하여 json value를 넣어야함
    // content-type도 필히 명시 필요 (application/json) request: {"content": "test"}
    @PostMapping("/test")
    public ResponseEntity uploadTest(@RequestPart ImageUploadRequest request, @RequestPart List<MultipartFile> files) {
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
