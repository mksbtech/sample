package com.milan.poc.reactive.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "firstName cannot be null")
	@NotEmpty(message = "firstName cannot be empty")
	private String firstName;

	@NotNull(message = "lastName cannot be null")
	@NotEmpty(message = "lastName cannot be empty")
	private String lastName;

	@NotNull(message = "email cannot be null")
	@NotEmpty(message = "email cannot be empty")
	@Email(message = "invalid email")
	private String email;

	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRequest(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
