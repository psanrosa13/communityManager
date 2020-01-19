package com.community.manager.communityManager;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.community.manager.communityManager.model.Interest;
import com.community.manager.communityManager.model.Theme;
import com.community.manager.communityManager.repository.InterestRepository;
import com.community.manager.communityManager.repository.ThemeRepository;

@SpringBootApplication
public class CommunityManagerApplication {

	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	InterestRepository interestRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CommunityManagerApplication.class, args);	
	}

	@PostConstruct
	private void insertData() {
		Theme theme1 = new Theme();
		theme1.setName("Backend");
		
		Theme theme2 = new Theme();
		theme2.setName("Metodologias");
		
		Theme theme3 = new Theme();
		theme3.setName("Testes");

		Theme theme4 = new Theme();
		theme4.setName("Mobile");
		
		themeRepository.save(theme1);
		themeRepository.save(theme2);
		themeRepository.save(theme3);
		themeRepository.save(theme4);
		
		Interest interest1= new Interest();
		interest1.setDescription("Java");
		interest1.setTheme(theme1);
		
		Interest interest2= new Interest();
		interest2.setDescription("Kotlin");
		interest2.setTheme(theme1);
		
		interestRepository.save(interest1);
		interestRepository.save(interest2);
	}

	
}
