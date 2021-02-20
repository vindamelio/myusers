package com.domain.users.service.dto;

public class UserFullNameDTO {


	
	private String fullName;
	
	public UserFullNameDTO() {
	}

	
	public UserFullNameDTO(String fullName) {
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
		return "UserFullNameDTO [fullName=" + fullName + "]";
	}

	
	
	
	
	
}
