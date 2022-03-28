package com.example.demo.Exceptions;

public class FileStorageException extends RuntimeException  {
	  private static final long serialVersionUID = 1L;
		public FileStorageException(String messg) {
			super(messg);
		}
		public FileStorageException(String messg,Throwable cause) {
			super(messg,cause);
		}
}
