package com.milan.cloud.function.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String firstName;
	
	@JsonProperty
	private String lastName;
	
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
	
	
	


}
