package com.teqstories.LibraryManagementSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teqstories.LibraryManagementSpringBoot.model.Book;
import com.teqstories.LibraryManagementSpringBoot.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		
		if (books == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(books);		// status 200
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		Book book = bookService.getBookById(id);
		
		if (book == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(book);		// status 200
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Book>> getBookByTitleAndAuthor(@RequestParam String title, @RequestParam String author) {
		List<Book> books = bookService.getBookByTitleAndAuthor(title, author);
		
		if (books == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(books);		// status 200
	}
	
	@PostMapping("/add")
	public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
		System.out.println(book);
		Book savedBook = bookService.addNewBook(book);
		if (savedBook == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(savedBook);		// status 200
	}
}
