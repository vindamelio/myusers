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

import com.domain.users.domain.PeopleEntity;
import com.domain.users.service.PeopleService;
import com.domain.users.service.dto.PeopleDTO;
import com.domain.users.service.dto.PeopleFullNameDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/people")
public class PeopleRestController {

	@Autowired
	PeopleService peopleService; 

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
	public ResponseEntity<List<PeopleDTO>> findAll() {
		List<PeopleDTO> lista = new ArrayList<PeopleDTO>();		
		try{
			lista = peopleService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(lista, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PeopleDTO> findOne(@PathVariable("id") Integer id) {

		PeopleDTO people = null;

		try{
			people = peopleService.findOneById(id);
			return new ResponseEntity<>(people, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(people, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	@RequestMapping(value = "/full/{id}", method = RequestMethod.GET)
	public ResponseEntity<PeopleFullNameDTO> findOneFullName(@PathVariable("id") Integer id) {

		PeopleFullNameDTO people = null;

		try{
			people = peopleService.getPeopleFullNameById(id);
			return new ResponseEntity<>(people, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(people, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	//@PostMapping
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<PeopleDTO> save(@RequestBody() PeopleDTO dto) {

		PeopleDTO people = null;
		try{
			people = peopleService.save(dto);
			return new ResponseEntity<>(people, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(people, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}


	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {

		try{
			peopleService.delete(id);
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>("error", HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}




}
