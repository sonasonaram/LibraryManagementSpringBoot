package com.teqstories.LibraryManagementSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teqstories.LibraryManagementSpringBoot.dao.MemberRepository;
import com.teqstories.LibraryManagementSpringBoot.model.Book;
import com.teqstories.LibraryManagementSpringBoot.model.Member;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
	
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

	
}
