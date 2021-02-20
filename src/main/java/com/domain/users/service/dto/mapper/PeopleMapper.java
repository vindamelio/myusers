package com.domain.users.service.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.domain.users.domain.PeopleEntity;
import com.domain.users.service.dto.PeopleDTO;
import com.domain.users.service.dto.PeopleFullNameDTO;

@Component
public class PeopleMapper {

	public PeopleMapper() {
	}

	
	public PeopleDTO entityToPeopleDTO(PeopleEntity entity) {
		
		if(entity==null) {
			return null;
		}
		
		PeopleDTO peopleDTO = new PeopleDTO();
		peopleDTO.setId(entity.getId());
		peopleDTO.setFirstName(entity.getFirstName());
		peopleDTO.setLastName(entity.getLastName());
		peopleDTO.setAge(entity.getAge());
		
		return peopleDTO;
	}

	public PeopleEntity peopleDTOToPeopleEntity(PeopleDTO dto) {
		
		if(dto==null) {
			return null;
		}
		
		PeopleEntity peopleEntity = new PeopleEntity();
		peopleEntity.setId(dto.getId());		
		peopleEntity.setFirstName(dto.getFirstName());
		peopleEntity.setLastName(dto.getLastName());
		peopleEntity.setAge(dto.getAge());
		
		return peopleEntity;
	}

	public List<PeopleDTO> entitiesToPeopleDTOs(List<PeopleEntity> entities) {
		if(entities==null) {
			return null;
		}
		return entities.stream().map(d -> entityToPeopleDTO(d)).collect(Collectors.toList());
	}

	public List<PeopleEntity> dtosToEntities(List<PeopleDTO> dtos) {
		if(dtos==null) {
			return null;
		}
		return dtos.stream().map(d -> peopleDTOToPeopleEntity(d)).collect(Collectors.toList());
	}
	

	
	
	public PeopleFullNameDTO entityToPeopleFullNameDTO(PeopleEntity entity) {
		
		if(entity==null) {
			return null;
		}
		PeopleFullNameDTO peopleFullNameDTO = new PeopleFullNameDTO();
		peopleFullNameDTO.setFullName(entity.getFirstName() + " " + entity.getLastName() + " " + entity.getAge());
		
		return peopleFullNameDTO;
	}

	public PeopleEntity peopleFullNameDTOToPeopleEntity(PeopleFullNameDTO dto) {
		
		if(dto==null) {
			return null;
		}
		PeopleEntity peopleEntity = null;
		
		if(dto.getFullName() != null) {
			String[] arra = dto.getFullName().split(" ");
			peopleEntity = new PeopleEntity();
			peopleEntity.setFirstName(arra[0]);
			peopleEntity.setLastName(arra[1]);
			peopleEntity.setAge(Integer.valueOf(arra[2]));
		}
		return peopleEntity;
	}

	public List<PeopleFullNameDTO> entitiesToPeopleFullNameDTOs(List<PeopleEntity> entities) {
		if(entities==null) {
			return null;
		}
		return entities.stream().map(d -> entityToPeopleFullNameDTO(d)).collect(Collectors.toList());
	}

	public List<PeopleEntity> FullNameDtosToEntities(List<PeopleFullNameDTO> dtos) {
		if(dtos==null) {
			return null;
		}
		return dtos.stream().map(d -> peopleFullNameDTOToPeopleEntity(d)).collect(Collectors.toList());
	}
	
	
	
	
}
