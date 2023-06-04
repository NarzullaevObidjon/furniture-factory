package com.company.furniturefactory.service;

import com.company.furniturefactory.dao.ImageDAO;
import com.company.furniturefactory.domain.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageDAO imageDAO;
    private final Path BASE_PATH = Path.of("D:/java/Spring/furnitureFactory/src/main/webapp/resources/img");

    public Long loadImage(MultipartFile image){

        String originalFilename = image.getOriginalFilename();
        String generatedFileName = UUID.randomUUID().toString();
        String contentType = image.getContentType();
        long size = image.getSize();
        String extension = StringUtils.getFilenameExtension(image.getOriginalFilename());

        String fullPath = BASE_PATH.resolve(generatedFileName + "." + extension).toString();
        File file = new File(fullPath);

        try {
            image.transferTo(file);
        } catch (IOException ignored) {
            return null;
        }

        return imageDAO.save(Image.childBuilder()
                .originalFileName(originalFilename)
                .generatedFileName(generatedFileName)
                .filePath(fullPath)
                .extension(extension)
                .size(size)
                .mimeType(contentType)
                .build());
    }
}
