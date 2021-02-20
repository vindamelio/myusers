package com.domain.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.users.domain.CarEntity;


@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer>{
	
	CarEntity findOneById(Integer id);

}
