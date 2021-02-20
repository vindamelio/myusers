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

import com.domain.users.components.SettaStringa;
import com.domain.users.domain.CarEntity;
import com.domain.users.service.CarsService;
import com.domain.users.service.dto.CarDTO;
import com.domain.users.service.dto.CarFullNameDTO;
import com.domain.users.service.dto.MessageDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/stringa")
public class StringaRestController {

	@Autowired
	SettaStringa settaStringa; 

	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<MessageDTO> riceviStringa() {
		MessageDTO ret = new MessageDTO();		

		try{
			ret.setMessage(settaStringa.getStringa());
			ret.setId(settaStringa.getCount());
			return new ResponseEntity<>(ret, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(ret, HttpStatus.SERVICE_UNAVAILABLE);   		
		}		

	}


}
