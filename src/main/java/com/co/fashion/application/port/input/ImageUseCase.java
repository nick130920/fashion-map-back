package com.co.fashion.application.port.input;

import com.co.fashion.application.dto.response.ImageResponse;
import com.co.fashion.domain.model.EntityType;
import com.co.fashion.domain.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageUseCase {
	ImageResponse uploadImage(Long entityId, EntityType entityType, MultipartFile file);

	List<Image> uploadImages(List<MultipartFile> files, Long entityId, EntityType entityType);

	List<Image> getImagesByEntity(EntityType entityType, Long id);
}
