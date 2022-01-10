package com.teqstories.LibraryManagementSpringBoot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.teqstories.LibraryManagementSpringBoot.exception.BookLimitReachedException;
import com.teqstories.LibraryManagementSpringBoot.exception.BookNotFoundException;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany (cascade = CascadeType.PERSIST)
	private List<Book> borrowedBooks;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public void borrow(Book book) throws BookLimitReachedException {
		if (borrowedBooks.size() >= 3)
			throw new BookLimitReachedException();
		
		borrowedBooks.add(book);
	}
	
	public void returnBook(Book book) throws BookNotFoundException {
		if (!borrowedBooks.contains(book))
			throw new BookNotFoundException();
		
		borrowedBooks.remove(book);
	}
}
