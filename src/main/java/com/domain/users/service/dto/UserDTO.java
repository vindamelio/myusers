package com.domain.users.service.dto;

public class UserDTO {

	private Integer id;
	
	private String account;
	
	private String mail;

	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public UserDTO(Integer id, String account, String mail) {
			this.id = id;		
			this.account = account;
			this.mail = mail;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", account=" + account + ", mail=" + mail + "]";
	}

	

}
