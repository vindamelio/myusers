package com.domain.users.service.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.domain.users.domain.UserEntity;
import com.domain.users.service.dto.UserDTO;
import com.domain.users.service.dto.UserFullNameDTO;

@Component
public class UserMapper {

	public UserMapper() {
	}

	
	public UserDTO entityToUserDTO(UserEntity entity) {
		
		if(entity==null) {
			return null;
		}
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(entity.getId());
		userDTO.setAccount(entity.getAccount());
		userDTO.setMail(entity.getMail());
		
		return userDTO;
	}

	public UserEntity userDTOToUserEntity(UserDTO dto) {
		
		if(dto==null) {
			return null;
		}
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(dto.getId());		
		userEntity.setAccount(dto.getAccount());
		userEntity.setMail(dto.getMail());
		
		return userEntity;
	}

	public List<UserDTO> entitiesToUserDTOs(List<UserEntity> entities) {
		if(entities==null) {
			return null;
		}
		return entities.stream().map(d -> entityToUserDTO(d)).collect(Collectors.toList());
	}

	public List<UserEntity> dtosToEntities(List<UserDTO> dtos) {
		if(dtos==null) {
			return null;
		}
		return dtos.stream().map(d -> userDTOToUserEntity(d)).collect(Collectors.toList());
	}
	

	
	
	public UserFullNameDTO entityToUserFullNameDTO(UserEntity entity) {
		
		if(entity==null) {
			return null;
		}
		UserFullNameDTO userFullNameDTO = new UserFullNameDTO();
		userFullNameDTO.setFullName(entity.getAccount() + " " + entity.getMail());
		
		return userFullNameDTO;
	}

	public UserEntity userFullNameDTOToUserEntity(UserFullNameDTO dto) {
		
		if(dto==null) {
			return null;
		}
		UserEntity userEntity = null;
		
		if(dto.getFullName() != null) {
			String[] arra = dto.getFullName().split(" ");
			userEntity = new UserEntity();
			userEntity.setAccount(arra[0]);
			userEntity.setMail(arra[1]);
		}
		return userEntity;
	}

	public List<UserFullNameDTO> entitiesToUserFullNameDTOs(List<UserEntity> entities) {
		if(entities==null) {
			return null;
		}
		return entities.stream().map(d -> entityToUserFullNameDTO(d)).collect(Collectors.toList());
	}

	public List<UserEntity> FullNameDtosToEntities(List<UserFullNameDTO> dtos) {
		if(dtos==null) {
			return null;
		}
		return dtos.stream().map(d -> userFullNameDTOToUserEntity(d)).collect(Collectors.toList());
	}
	
	
	
	
}
