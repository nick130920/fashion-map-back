package com.co.fashion.application.exception;

public class ImageStorageException extends RuntimeException{
	public ImageStorageException(String message, Throwable cause) {
		super(message, cause);
	}
	public ImageStorageException(String message) {
		super(message);
	}

}