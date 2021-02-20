package com.domain.users.service.dto;

public class PeopleFullNameDTO {


	
	private String fullName;
	
	public PeopleFullNameDTO() {
	}

	
	public PeopleFullNameDTO(String fullName) {
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
		return "PeopleFullNameDTO [fullName=" + fullName + "]";
	}

	
	
	
	
	
}
