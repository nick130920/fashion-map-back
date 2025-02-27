package com.co.fashion.application.port.output;

import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

public interface ImageStoragePort {
	URL uploadImage(MultipartFile file);
	void deleteImage(String filename);
}
