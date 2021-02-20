package com.domain.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.domain.users.domain.UserEntity;
import com.domain.users.repository.UserRepository;
import com.domain.users.service.UsersService;
import com.domain.users.service.dto.UserDTO;
import com.domain.users.service.dto.UserFullNameDTO;
import com.domain.users.service.dto.mapper.UserMapper;

@Component
@Transactional
public class UsersServiceImpl implements UsersService{
	

	@Autowired
	UserRepository userRepository; 

	@Autowired
	UserMapper userMapper; 

	@Autowired
	private JmsTemplate jmsTemplate;

	//@Value("${destination.first}")
	private String firstDestination = "prima-destinazione";

	@Override
	public List<UserDTO> findAll(){
		
		List<UserEntity> entities = userRepository.findAll();
		return userMapper.entitiesToUserDTOs(entities);
	};

	@Override
	public UserDTO findOneById(Integer id){
		
		UserEntity entity = userRepository.findOneById(id);
		UserDTO resDTO = userMapper.entityToUserDTO(entity);
		return resDTO;
	};
	
	@Override
	public UserFullNameDTO getUserFullNameById(Integer id){
		
		UserEntity entity = userRepository.findOneById(id);
		UserFullNameDTO resDTO = userMapper.entityToUserFullNameDTO(entity);
		return resDTO;
	};
	
	@Override
	public UserDTO save(UserDTO dto){
		
		UserEntity entity = userMapper.userDTOToUserEntity(dto);

		if(!(entity.getId()>0)){
			List<UserEntity> lista = new ArrayList<UserEntity>();		
			lista = userRepository.findAll();
			Integer id = trovaMax(lista) + 1;
			entity.setId(id);
		}
		UserEntity res = userRepository.save((UserEntity)entity);
		UserDTO resDTO = userMapper.entityToUserDTO(res);

		String message = "sending user saved id:" + res.getId();
		jmsTemplate.convertAndSend(firstDestination, message);

		return resDTO;
		
	};	
	

	@Override
	public void delete(Integer userId) {
		userRepository.deleteById(userId);
	}

	private Integer trovaMax(List<UserEntity>in) {

		Integer max = 0;
		try{
			for(UserEntity us:in){
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
