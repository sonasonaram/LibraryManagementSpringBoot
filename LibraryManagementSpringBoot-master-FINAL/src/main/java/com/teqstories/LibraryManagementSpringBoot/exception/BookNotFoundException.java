package com.teqstories.LibraryManagementSpringBoot.exception;

public class BookNotFoundException extends Exception {
	
	public BookNotFoundException() {
		super("Book not found");
	}
}
