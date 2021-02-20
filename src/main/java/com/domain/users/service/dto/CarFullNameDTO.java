package com.domain.users.service.dto;

public class CarFullNameDTO {


	
	private String fullName;
	
	public CarFullNameDTO() {
	}

	
	public CarFullNameDTO(String fullName) {
			this.fullName = fullName;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	@Override
	public String toString() {
		return "CarFullNameDTO [fullName=" + fullName + "]";
	}

	
	
	
	
	
}
