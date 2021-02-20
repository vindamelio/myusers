package com.domain.users.service;



import java.util.List;

import com.domain.users.domain.UserEntity;
import com.domain.users.service.dto.UserDTO;
import com.domain.users.service.dto.UserFullNameDTO;

public interface UsersService {
	


	public List<UserDTO> findAll();
	
	public UserDTO findOneById(Integer id);
	public UserFullNameDTO getUserFullNameById(Integer id);

	//public void save(UserEntity userEntity);
	public UserDTO save(UserDTO userDTO);

	public void delete(Integer id);


}
