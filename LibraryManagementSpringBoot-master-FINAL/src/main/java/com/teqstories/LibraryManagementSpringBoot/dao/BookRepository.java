package com.teqstories.LibraryManagementSpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teqstories.LibraryManagementSpringBoot.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Optional<List<Book>> findByAuthor(String author);
	Optional<List<Book>> findByTitle(String title);
	Optional<List<Book>> findByTitleAndAuthor(String title, String author);
}
