package com.teqstories.LibraryManagementSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teqstories.LibraryManagementSpringBoot.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
