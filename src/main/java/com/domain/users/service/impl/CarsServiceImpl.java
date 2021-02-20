package com.domain.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.domain.users.domain.CarEntity;
import com.domain.users.repository.CarRepository;
import com.domain.users.service.CarsService;
import com.domain.users.service.dto.CarDTO;
import com.domain.users.service.dto.CarFullNameDTO;
import com.domain.users.service.dto.mapper.CarMapper;

@Component
@Transactional
public class CarsServiceImpl implements CarsService{
	
	@Autowired
	CarRepository carRepository; 

	@Autowired
	CarMapper carMapper; 

	@Autowired
	private JmsTemplate jmsTemplate;

	//@Value("${destination.first}")
	private String firstDestination = "prima-destinazione";


	@Override
	public List<CarDTO> findAll(){
		
		List<CarEntity> entities = carRepository.findAll();
		return carMapper.entitiesToCarDTOs(entities);
	};

	@Override
	public CarDTO findOneById(Integer id){
		
		CarEntity entity = carRepository.findOneById(id);
		CarDTO resDTO = carMapper.entityToCarDTO(entity);
		return resDTO;
	};
	
	@Override
	public CarFullNameDTO getCarFullNameById(Integer id){
		
		CarEntity entity = carRepository.findOneById(id);
		CarFullNameDTO resDTO = carMapper.entityToCarFullNameDTO(entity);
		return resDTO;
	};
	
	@Override
	public CarDTO save(CarDTO dto){
		
		CarEntity entity = carMapper.carDTOToCarEntity(dto);

		if(!(entity.getId()>0)){
			List<CarEntity> lista = new ArrayList<CarEntity>();		
			lista = carRepository.findAll();
			Integer id = trovaMax(lista) + 1;
			entity.setId(id);
		}

		CarEntity res = carRepository.save((CarEntity)entity);
		CarDTO resDTO = carMapper.entityToCarDTO(res);

		String message = "sending car saved id:" + res.getId();
		jmsTemplate.convertAndSend(firstDestination, message);

		return resDTO;
		
	};	
	

	@Override
	public void delete(Integer id) {
		carRepository.deleteById(id);
	}

	private Integer trovaMax(List<CarEntity>in) {

		Integer max = 0;
		try{
			for(CarEntity us:in){
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
