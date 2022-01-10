package com.teqstories.LibraryManagementSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teqstories.LibraryManagementSpringBoot.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
