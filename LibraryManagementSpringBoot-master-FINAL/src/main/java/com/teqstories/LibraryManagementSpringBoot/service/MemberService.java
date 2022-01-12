package com.teqstories.LibraryManagementSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teqstories.LibraryManagementSpringBoot.dao.MemberRepository;
import com.teqstories.LibraryManagementSpringBoot.exception.BookLimitReachedException;
import com.teqstories.LibraryManagementSpringBoot.exception.BookNotFoundException;
import com.teqstories.LibraryManagementSpringBoot.model.Book;
import com.teqstories.LibraryManagementSpringBoot.model.Member;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BookService bookService;
	
	public List<Member> getAllMembers() {
		return memberRepo.findAll();
	}
	
	public Member addNewMember(Member member) {
		return memberRepo.save(member);
	}

	public Member getMemberById(int id) {
		return memberRepo.findById(id).get();
	}

	public void deleteMemberById(int id) {
		memberRepo.deleteById(id);
	}
	
	public Member borrowBook(int memberId, int bookId) {
		Member member = getMemberById(memberId);
		Book book = bookService.getBookById(bookId);
		try {
			member.borrow(book);
			return memberRepo.save(member);
		} catch (BookLimitReachedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Member returnBook(int memberId, int bookId) {
		Member member = getMemberById(memberId);
		Book book = bookService.getBookById(bookId);
		try {
			member.returnBook(book);
			return memberRepo.save(member);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
