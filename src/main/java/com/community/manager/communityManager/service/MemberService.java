package com.community.manager.communityManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.manager.communityManager.exception.MemberInexistenteException;
import com.community.manager.communityManager.model.Member;
import com.community.manager.communityManager.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	

	public Member insert(Member member) {
		return memberRepository.save(member);
	}

	public Member consultMemberForId(Long id) {
		return memberRepository.getOne(id);
	}

	public void delete(Long id) {
		if(!memberRepository.existsById(id)) {
			throw new MemberInexistenteException();
		}
		memberRepository.deleteById(id);		
	}

	public Member alter(Member member, Long id) {
		if(!memberRepository.existsById(id)) {
			throw new MemberInexistenteException();
		}
				
		return memberRepository.save(member);
	}
	
	
}
