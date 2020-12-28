package com.milan.postgres.poc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milan.postgres.poc.model.EmployeeRequest;
import com.milan.postgres.poc.model.ResponseDto;
import com.milan.postgres.poc.service.EmployeeService;

import io.micrometer.core.instrument.util.StringUtils;


@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto save(@Valid @RequestBody EmployeeRequest request) {
		return employeeService.createEmployee(request);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto fetch(@RequestHeader(name = "Email-Id",required = false) String email) {
		if(StringUtils.isEmpty(email)) {
			return employeeService.fetchEmployees();
		}
		else {
		return employeeService.fetchEmployee(email);
		}
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto update(@Valid @RequestBody EmployeeRequest request) {
		return employeeService.updateEmployee(request);
	}

}
