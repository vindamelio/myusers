package com.domain.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.domain.users.domain.PeopleEntity;
import com.domain.users.repository.PeopleRepository;
import com.domain.users.service.PeopleService;
import com.domain.users.service.dto.PeopleDTO;
import com.domain.users.service.dto.PeopleFullNameDTO;
import com.domain.users.service.dto.mapper.PeopleMapper;

@Component
@Transactional
public class PeopleServiceImpl implements PeopleService{
	
	@Autowired
	PeopleRepository peopleRepository; 

	@Autowired
	PeopleMapper peopleMapper; 

	@Autowired
	private JmsTemplate jmsTemplate;

	//@Value("${destination.first}")
	private String firstDestination = "prima-destinazione";


	@Override
	public List<PeopleDTO> findAll(){
		
		List<PeopleEntity> entities = peopleRepository.findAll();
		return peopleMapper.entitiesToPeopleDTOs(entities);
	};

	@Override
	public PeopleDTO findOneById(Integer id){
		
		PeopleEntity entity = peopleRepository.findOneById(id);
		PeopleDTO resDTO = peopleMapper.entityToPeopleDTO(entity);
		return resDTO;
	};
	
	@Override
	public PeopleFullNameDTO getPeopleFullNameById(Integer id){
		
		PeopleEntity entity = peopleRepository.findOneById(id);
		PeopleFullNameDTO resDTO = peopleMapper.entityToPeopleFullNameDTO(entity);
		return resDTO;
	};
	
	@Override
	public PeopleDTO save(PeopleDTO dto){
		
		PeopleEntity entity = peopleMapper.peopleDTOToPeopleEntity(dto);

		if(!(entity.getId()>0)){
			List<PeopleEntity> lista = new ArrayList<PeopleEntity>();		
			lista = peopleRepository.findAll();
			Integer id = trovaMax(lista) + 1;
			entity.setId(id);
		}
		PeopleEntity res = peopleRepository.save((PeopleEntity)entity);
		PeopleDTO resDTO = peopleMapper.entityToPeopleDTO(res);

		String message = "sending people saved id:" + res.getId();
		jmsTemplate.convertAndSend(firstDestination, message);


		return resDTO;
		
	};	
	

	@Override
	public void delete(Integer userId) {
		peopleRepository.deleteById(userId);
	}

	private Integer trovaMax(List<PeopleEntity>in) {

		Integer max = 0;
		try{
			for(PeopleEntity us:in){
				Integer id = us.getId();
				if(id > max){
					max = id;
				}	
			}
			return max;
		}catch(Exception e){
			throw (e);   		
		}		

	}

}
