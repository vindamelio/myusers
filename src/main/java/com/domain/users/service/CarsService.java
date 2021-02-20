package com.domain.users.service;



import java.util.List;

import com.domain.users.domain.CarEntity;
import com.domain.users.service.dto.CarDTO;
import com.domain.users.service.dto.CarFullNameDTO;

public interface CarsService {
	


	public List<CarDTO> findAll();
	
	public CarDTO findOneById(Integer id);
	public CarFullNameDTO getCarFullNameById(Integer id);

	//public void save(CarEntity carEntity);
	public CarDTO save(CarDTO carDTO);

	public void delete(Integer id);


}
