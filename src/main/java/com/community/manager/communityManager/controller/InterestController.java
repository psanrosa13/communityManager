package com.community.manager.communityManager.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.manager.communityManager.model.Interest;
import com.community.manager.communityManager.service.InterestService;

@RestController
@RequestMapping("/interest")
public class InterestController {

	@Autowired
	InterestService interestService;
	
	@PostMapping
	public Interest include(@Valid Interest interest) {
		return interestService.save(interest); 
	}
	
	@GetMapping("/{id}")
	public Interest consult(@PathParam(value = "") Long id) {
		return interestService.consultInterestForId(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathParam(value = "") Long id) {
		interestService.delete(id);
	}
	
	@PutMapping("/{id}")
	public Interest alter(@PathParam(value = "") Long id, Interest interest) {
		return interestService.alter(interest, id);
	}
	
	@GetMapping("/all")
	public List<Interest> list() {
		return interestService.consultAll();
	}
}
