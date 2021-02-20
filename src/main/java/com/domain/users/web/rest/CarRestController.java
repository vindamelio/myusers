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

import com.domain.users.domain.CarEntity;
import com.domain.users.service.CarsService;
import com.domain.users.service.dto.CarDTO;
import com.domain.users.service.dto.CarFullNameDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cars")
public class CarRestController {

	@Autowired
	CarsService carsService; 

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
	public ResponseEntity<List<CarDTO>> findAll() {
		List<CarDTO> lista = new ArrayList<CarDTO>();		
		try{
			lista = carsService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(lista, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CarDTO> findOne(@PathVariable("id") Integer id) {

		CarDTO car = null;

		try{
			car = carsService.findOneById(id);
			return new ResponseEntity<>(car, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(car, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	@RequestMapping(value = "/full/{id}", method = RequestMethod.GET)
	public ResponseEntity<CarFullNameDTO> findOneFullName(@PathVariable("id") Integer id) {

		CarFullNameDTO car = null;

		try{
			car = carsService.getCarFullNameById(id);
			return new ResponseEntity<>(car, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(car, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}

	//@PostMapping
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<CarDTO> save(@RequestBody() CarDTO dto) {

		CarDTO car = null;
		try{
			car = carsService.save(dto);
			return new ResponseEntity<>(car, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(car, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}


	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {

		try{
			carsService.delete(id);
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>("error", HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}




}
