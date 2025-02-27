package com.co.fashion.application.service;

import com.co.fashion.application.dto.response.ImageResponse;
import com.co.fashion.application.exception.ImageUploadException;
import com.co.fashion.application.port.input.ImageUseCase;
import com.co.fashion.application.port.output.ImageRepositoryPort;
import com.co.fashion.application.port.output.ImageStoragePort;
import com.co.fashion.domain.model.EntityType;
import com.co.fashion.domain.model.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements ImageUseCase {

	private static final List<String> ALLOWED_FILE_TYPES = List.of("image/jpeg", "image/png", "image/webp");
	private static final long MAX_FILE_SIZE = 5 * 1024L * 1024L;
	private final ImageRepositoryPort imageRepositoryPort;
	private final ImageStoragePort imageStoragePort;


	@Override
	public ImageResponse uploadImage(Long entityId, EntityType entityType, MultipartFile file) {
		validateFile(file);
		try {
			URL imageUrl = imageStoragePort.uploadImage(file);

			Image image = Image.builder()
					.url(imageUrl.toString())
					.entityId(entityId)
					.entityType(entityType)
					.build();
			Image savedImage = imageRepositoryPort.save(image);

			return new ImageResponse(savedImage.getId(), savedImage.getUrl());
		} catch (Exception e) {
			throw new ImageUploadException("Error uploading image: " + file.getOriginalFilename(), e);
		}
	}

	@Override
	@Transactional
	public List<Image> uploadImages(List<MultipartFile> files, Long entityId, EntityType entityType) {

		if (files == null || files.isEmpty()) {
			return Collections.emptyList();
		}


		return files.parallelStream() // Procesar imágenes en paralelo
				.map(file -> {
					validateFile(file);
					try {
						URL imageUrl = imageStoragePort.uploadImage(file);
						return Image.builder()
								.url(imageUrl.toString())
								.entityType(entityType)
								.entityId(entityId)
								.build();
					} catch (Exception e) {
						throw new ImageUploadException("Failed to upload image: " + file.getOriginalFilename(), e);
					}
				})
				.map(imageRepositoryPort::save)
				.toList();
	}

	@Override
	@Transactional
	public List<Image> getImagesByEntity(EntityType entityType, Long id) {
        return imageRepositoryPort.findByEntityTypeAndEntityId(entityType, id).orElse(Collections.emptyList());
    }

	private void validateFile(MultipartFile file) {
		if (file == null || file.isEmpty()) {
			throw new ImageUploadException("No file provided:" );
		}

		if (!ALLOWED_FILE_TYPES.contains(file.getContentType())) {
			throw new ImageUploadException("Invalid file type. Supported types: " + String.join(", ", ALLOWED_FILE_TYPES));
		}

		if (file.getSize() > MAX_FILE_SIZE) {
			throw new ImageUploadException("File size exceeds the maximum allowed size. Max size: " + (MAX_FILE_SIZE / (1024 * 1024)) + " MB");
		}
	}

}
