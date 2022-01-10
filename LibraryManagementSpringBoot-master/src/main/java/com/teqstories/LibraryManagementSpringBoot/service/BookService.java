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

	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}

	public List<Book> getBookByTitleAndAuthor(String title, String author) {
		if (null != title && title.trim() != "" && null != author && author.trim() != "")
			return bookRepo.findByTitleAndAuthor(title, author).get();
		else if(null != title && title.trim() != "")
			return bookRepo.findByTitle(title).get();
		else if (null != author && author.trim() != "")
			return bookRepo.findByAuthor(author).get();
		
		return null;
	}
	
	
}
