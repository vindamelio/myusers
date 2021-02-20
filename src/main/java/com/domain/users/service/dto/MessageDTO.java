package com.domain.users.service.dto;

public class MessageDTO {

	private Integer id;
	private String message;
	
	public MessageDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public MessageDTO(Integer id, String message) {
			this.id = id;		
			this.message = message;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", message=" + message + "]";
	}

	


}
