package com.community.manager.communityManager.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.manager.communityManager.exception.InteresseInexisteException;
import com.community.manager.communityManager.model.Interest;
import com.community.manager.communityManager.repository.InterestRepository;

@Service
public class InterestService {

	@Autowired
	InterestRepository interestRepository;

	public Interest save(@Valid Interest interest) {
		return interestRepository.save(interest);
	}

	public Interest consultInterestForId(Long id) {
		return interestRepository.getOne(id);
	}

	public void delete(Long id) {
		if (!interestRepository.existsById(id)) {
			throw new InteresseInexisteException();
		}
		
		interestRepository.deleteById(id);
	}

	public Interest alter(Interest interest, Long id) {
		if (!interestRepository.existsById(id)) {
			throw new InteresseInexisteException();
		}
		
		return interestRepository.save(interest);
	}

	public List<Interest> consultAll() {
		return interestRepository.findAll();
	}
	
	
}
