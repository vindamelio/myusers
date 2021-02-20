package com.domain.users.service.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.domain.users.domain.CarEntity;
import com.domain.users.service.dto.CarDTO;
import com.domain.users.service.dto.CarFullNameDTO;

@Component
public class CarMapper {

	public CarMapper() {
	}

	
	public CarDTO entityToCarDTO(CarEntity entity) {
		
		if(entity==null) {
			return null;
		}
		
		CarDTO carDTO = new CarDTO();
		carDTO.setId(entity.getId());
		carDTO.setFactory(entity.getFactory());
		carDTO.setName(entity.getName());
		carDTO.setPower(entity.getPower());
		carDTO.setType(entity.getType());

		return carDTO;
	}

	public CarEntity carDTOToCarEntity(CarDTO dto) {
		
		if(dto==null) {
			return null;
		}
		
		CarEntity carEntity = new CarEntity();
		carEntity.setId(dto.getId());
		carEntity.setFactory(dto.getFactory());
		carEntity.setName(dto.getName());
		carEntity.setPower(dto.getPower());
		carEntity.setType(dto.getType());
		
		return carEntity;
	}

	public List<CarDTO> entitiesToCarDTOs(List<CarEntity> entities) {
		if(entities==null) {
			return null;
		}
		return entities.stream().map(d -> entityToCarDTO(d)).collect(Collectors.toList());
	}

	public List<CarEntity> dtosToEntities(List<CarDTO> dtos) {
		if(dtos==null) {
			return null;
		}
		return dtos.stream().map(d -> carDTOToCarEntity(d)).collect(Collectors.toList());
	}
	

	
	
	public CarFullNameDTO entityToCarFullNameDTO(CarEntity entity) {
		
		if(entity==null) {
			return null;
		}
		CarFullNameDTO carFullNameDTO = new CarFullNameDTO();
		carFullNameDTO.setFullName(entity.getFactory() + " " + entity.getName() + " " + entity.getPower() + " " + entity.getType());
		
		return carFullNameDTO;
	}

	public CarEntity carFullNameDTOToCarEntity(CarFullNameDTO dto) {
		
		if(dto==null) {
			return null;
		}
		CarEntity carEntity = null;
		
		if(dto.getFullName() != null) {
			String[] arra = dto.getFullName().split(" ");
			carEntity = new CarEntity();
			carEntity.setFactory(arra[0]);
			carEntity.setName(arra[1]);
			carEntity.setPower(Integer.valueOf( arra[2] ) );
			carEntity.setType(arra[3]);
		}
		return carEntity;
	}

	public List<CarFullNameDTO> entitiesToCarFullNameDTOs(List<CarEntity> entities) {
		if(entities==null) {
			return null;
		}
		return entities.stream().map(d -> entityToCarFullNameDTO(d)).collect(Collectors.toList());
	}

	public List<CarEntity> FullNameDtosToEntities(List<CarFullNameDTO> dtos) {
		if(dtos==null) {
			return null;
		}
		return dtos.stream().map(d -> carFullNameDTOToCarEntity(d)).collect(Collectors.toList());
	}
	
	
	
	
}
