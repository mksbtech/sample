package com.milan.poc.reactive.controller;

import java.util.List;

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

import com.milan.poc.reactive.entity.Employee;
import com.milan.poc.reactive.model.EmployeeDto;
import com.milan.poc.reactive.model.EmployeeRequest;
import com.milan.poc.reactive.model.ResponseDto;
import com.milan.poc.reactive.service.ReactiveEmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/reactive-employees")
public class ReactiveEmployeeController {
	@Autowired
	private ReactiveEmployeeService reactiveEmployeeService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseDto> save(@Valid @RequestBody EmployeeRequest request) {
		return reactiveEmployeeService.createEmployee(request);
	}
	
//	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//	public Mono<ResponseDto> fetch(@RequestHeader(name = "Email-Id",required = false) String email) {
//		if(StringUtils.isEmpty(email)) {
//			return reactiveEmployeeService.fetchEmployees();
//		}
//		else {
//		return reactiveEmployeeService.fetchEmployee(email);
//		}
//	}
	
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Object> fetch(@RequestHeader(name = "Email-Id",required = false) String email) {
		
			return reactiveEmployeeService.fetchEmployees();
		
		
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseDto> update(@Valid @RequestBody EmployeeRequest request) {
		return reactiveEmployeeService.updateEmployee(request);
	}

}
