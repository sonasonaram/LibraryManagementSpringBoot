package com.teqstories.LibraryManagementSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teqstories.LibraryManagementSpringBoot.dao.BookRepository;
import com.teqstories.LibraryManagementSpringBoot.model.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	public Book addNewBook(Book book) {
		return bookRepo.save(book);
	}
}
