package com.milan.openapi.employee.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.milan.openapi.employee.model.Employee;

@Service
public class EmployeeService {
	private CopyOnWriteArrayList<Employee> empList;
	
	@PostConstruct
	public void initialize()
	{
		empList = new CopyOnWriteArrayList<>();
		Employee e = null;
		for(int i=0;i<10;i+=1) {
			e = new Employee();
			e.setId(i);
			e.setFirstName("firstName"+i);
			e.setMiddleName("middleName"+i);
			e.setLastName("lastName"+i);
			empList.add(e);
		}
	}
	
	public Employee getEmployeeById(int id)
	{
		return empList.parallelStream().filter((e)->(e.getId()==id)).collect(Collectors.toList()).get(0);
	}
	
	public List<Employee> getAllEmployees()
	{
		return empList;
	}
	
	public boolean addEmployee(Employee emp)
	{
		boolean result = false;
		empList.add(emp);
		result=true;
		return result;
	}
	
	public Employee deleteEmployee(int id)
	{		
		Employee emp = getEmployeeById(id);		
		empList.remove(emp);		
		return emp;
	}
	
	public boolean updateEmployee(Employee e)
	{
		boolean result = false;
		Employee emp = getEmployeeById(e.getId());		
		emp.setFirstName(e.getFirstName());
		emp.setMiddleName(e.getMiddleName());
		emp.setLastName(e.getLastName());
		result=true;
		return result;
	}
}
