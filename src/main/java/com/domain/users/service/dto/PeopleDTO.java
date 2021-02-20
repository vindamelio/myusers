package com.domain.users.service.dto;

public class PeopleDTO {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;

	
	public PeopleDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public PeopleDTO(Integer id, String firstName, String lastName, Integer age) {
            this.id = id;        
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "PeopleDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

}
