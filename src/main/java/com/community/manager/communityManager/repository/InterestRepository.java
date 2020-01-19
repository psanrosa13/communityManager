package com.community.manager.communityManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.community.manager.communityManager.model.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

}
