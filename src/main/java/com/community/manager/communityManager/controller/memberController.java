package com.community.manager.communityManager.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.manager.communityManager.model.Member;
import com.community.manager.communityManager.service.MemberService;

@RestController
@RequestMapping("/member")
public class memberController {

	@Autowired
	MemberService memberService;
	
	@PostMapping
	public Member insert(@Valid Member member){
		return memberService.insert(member);
	}
	
	@GetMapping("/{id}")
	public Member consult(@PathParam(value = "") Long id) {
		return memberService.consultMemberForId(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathParam(value = "") Long id) {
		memberService.delete(id);
	}
	
	@PutMapping("/{id}")
	public Member alter(Member member, @PathParam(value = "") Long id) {
		return memberService.alter(member, id);
	}
}
