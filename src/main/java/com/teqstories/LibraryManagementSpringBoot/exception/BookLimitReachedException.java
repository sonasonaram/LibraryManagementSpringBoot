package com.teqstories.LibraryManagementSpringBoot.exception;

public class BookLimitReachedException extends Exception {

	public BookLimitReachedException() {
		super("Book Borrowing Limit Reached");
	}
}
