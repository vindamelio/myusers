package com.domain.users.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String account;
	
	private String mail;

	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}

	
	public UserEntity(Integer id, String account, String mail) {
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
		return "UserEntity [id=" + id + ", account=" + account + ", mail=" + mail + "]";
	}

	
	

}
