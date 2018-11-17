package com.milan.api.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

public class ApiException {
	@Getter @Setter
	private HttpStatus status;
	@Getter @Setter @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	@Getter	@Setter
	private String message;

	@Getter	@Setter
	private String debugMessage;

	@Getter	@Setter
	private List<ApiSubException> subErrors;

	private ApiException() {
		timestamp = LocalDateTime.now();
	}

	public ApiException(HttpStatus status) {
		this();
		this.setStatus(status);
	}
	
	public ApiException(Throwable ex) {
		this();
		this.debugMessage = ex.getLocalizedMessage();		
	}

	ApiException(HttpStatus status, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage("Unexpected error");
		this.debugMessage = ex.getLocalizedMessage();
	}

	ApiException(HttpStatus status, String message, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage(message);
		this.debugMessage = ex.getLocalizedMessage();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
