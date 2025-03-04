package com.co.fashion.infrastructure.adapter.output.storage;

import com.co.fashion.application.exception.ImageStorageException;
import com.co.fashion.application.port.output.ImageStoragePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service("localStorage")
public class LocalStorageService implements ImageStoragePort {

	private final Path uploadDir;

	public LocalStorageService(@Value("${storage.local.upload-dir}") String uploadDir) {

		this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.uploadDir);
		}catch (IOException e){
			throw new ImageStorageException("Error creating directory for images", e);
		}
	}

	@Override
	public URL uploadImage(MultipartFile file) {
		validateFile(file);

		String sanitizedFileName = sanitizeFileName(Objects.requireNonNull(file.getOriginalFilename()));
		String uniqueFileName = UUID.randomUUID() + "_" + sanitizedFileName;
		Path filePath = uploadDir.resolve(uniqueFileName);

		try {
			Files.copy(file.getInputStream(), filePath);
			return filePath.toUri().toURL();
		} catch (IOException e) {
			throw new ImageStorageException("Error saving image locally", e);
		}
	}

	@Override
	public void deleteImage(String fileName) {
		try {
			Path filePath = uploadDir.resolve(fileName).normalize();
			if (!filePath.startsWith(uploadDir)) {
				throw new ImageStorageException("Attempted to delete file outside upload directory");
			}
			Files.deleteIfExists(filePath);
		} catch (Exception e) {
			throw new ImageStorageException("Error deleting image", e);
		}
	}

	private void validateFile(MultipartFile file) {
		if (file.isEmpty()) {
			throw new ImageStorageException("File is empty: " + file.getOriginalFilename());
		}
	}
	private String sanitizeFileName(String fileName) {
		return fileName.replaceAll("[^a-zA-Z0-9.\\-_]", "_");
	}
}
