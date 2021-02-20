package com.domain.users.service;



import java.util.List;

import com.domain.users.domain.PeopleEntity;
import com.domain.users.service.dto.PeopleDTO;
import com.domain.users.service.dto.PeopleFullNameDTO;

public interface PeopleService {
	


	public List<PeopleDTO> findAll();
	
	public PeopleDTO findOneById(Integer id);
	public PeopleFullNameDTO getPeopleFullNameById(Integer id);

	//public void save(UserEntity userEntity);
	public PeopleDTO save(PeopleDTO peopleDTO);

	public void delete(Integer id);


}
