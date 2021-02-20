package com.domain.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.users.domain.PeopleEntity;


@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, Integer>{
	
	PeopleEntity findOneById(Integer id);

}
