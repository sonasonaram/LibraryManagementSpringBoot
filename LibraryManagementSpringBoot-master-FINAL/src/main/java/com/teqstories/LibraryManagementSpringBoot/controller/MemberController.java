package com.teqstories.LibraryManagementSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teqstories.LibraryManagementSpringBoot.model.Member;
import com.teqstories.LibraryManagementSpringBoot.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Member>> getAllMembers() {
		List<Member> members = memberService.getAllMembers();
		
		if (members == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(members);		// status 200
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable int id) {
		Member member = memberService.getMemberById(id);
		
		if (member == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(member);		// status 200
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable int id) {
		memberService.deleteMemberById(id);
		
		return ResponseEntity.ok("Deletion Successful");		// status 200
	}
	
	@PostMapping("/add")
	public ResponseEntity<Member> addNewMember(@RequestBody Member member) {
		Member savedMember = memberService.addNewMember(member);
		if (savedMember == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(savedMember);		// status 200
	}
	
	@PostMapping("/borrow")
	public ResponseEntity<Member> borrowBook(@RequestParam int memberId, @RequestParam int bookId) {
		Member savedMember = memberService.borrowBook(memberId, bookId);
		if (savedMember == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(savedMember);		// status 200
	}
	
	@PostMapping("/return")
	public ResponseEntity<Member> returnBook(@RequestParam int memberId, @RequestParam int bookId) {
		Member savedMember = memberService.returnBook(memberId, bookId);
		if (savedMember == null)
			return ResponseEntity.notFound().build();	// status 404
		
		return ResponseEntity.ok(savedMember);		// status 200
	}
}
