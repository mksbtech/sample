package com.milan.postgres.poc.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.milan.postgres.poc.entity.Employee;
import com.milan.postgres.poc.exception.ApiException;
import com.milan.postgres.poc.model.EmployeeRequest;
import com.milan.postgres.poc.model.ResponseDto;
import com.milan.postgres.poc.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public ResponseDto fetchEmployees() {
		ResponseDto response = new ResponseDto();
		List<Employee> employeeList = employeeRepository.findAll();
		if(employeeList.isEmpty()) {
			throw new ApiException("ERR-101","No data found");
		}
		response.setData(employeeList);
		response.setStatus("success");
		return response;
	}
	
	public ResponseDto fetchEmployee(String email) {
		ResponseDto response = new ResponseDto();
		Employee employee = employeeRepository.findByEmail(email);
		response.setData(employee);
		response.setStatus("success");
		return response;
	}
	
	@Transactional
	public ResponseDto createEmployee(EmployeeRequest request) {
		Employee employee = new Employee(request.getFirstName(), request.getLastName(),request.getEmail());
		employee.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		Employee savedEmployee = employeeRepository.save(employee);
		ResponseDto response = new ResponseDto();
		response.setData(savedEmployee);
		response.setStatus("success");
		return response;
	}
	
	@Transactional
	public ResponseDto updateEmployee(EmployeeRequest request) {
		Employee employee = employeeRepository.findByEmail(request.getEmail());
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setUpdatedOn(new Timestamp(System.currentTimeMillis()));
		Employee savedEmployee = employeeRepository.save(employee);
		ResponseDto response = new ResponseDto();
		response.setData(savedEmployee);
		response.setStatus("success");
		return response;
	}
}
