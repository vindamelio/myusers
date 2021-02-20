package com.domain.users.web.rest;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.domain.users.domain.UserEntity;
import com.domain.users.service.UsersService;
import com.domain.users.service.dto.UserDTO;
import com.domain.users.service.dto.UserFullNameDTO;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8081"} )
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	UsersService usersService; 

	//@GetMapping
	//public List<UserDTO> findAll() {
	//	return usersService.findAll();
	//}

	//@PostMapping
	//public void savea(@RequestBody UserDTO userDTO) {	
	//	usersService.save(userDTO);
	//}
	
	//@GetMapping
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> lista = new ArrayList<UserDTO>();		
		try{
			lista = usersService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(lista, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findOne(@PathVariable("id") Integer id) {

		UserDTO user = null;

		try{
			user = usersService.findOneById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(user, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	@RequestMapping(value = "/full/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserFullNameDTO> findOneFullName(@PathVariable("id") Integer id) {

		UserFullNameDTO user = null;

		try{
			user = usersService.getUserFullNameById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(user, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	//@PostMapping
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> save(@RequestBody() UserDTO dto) {

		UserDTO user = null;
		try{
			user = usersService.save(dto);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(user, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}


	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {

		try{
			usersService.delete(id);
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>("error", HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}




}
