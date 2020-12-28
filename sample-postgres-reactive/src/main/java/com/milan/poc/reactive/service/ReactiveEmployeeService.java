package com.milan.poc.reactive.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import com.milan.poc.reactive.entity.Employee;
import com.milan.poc.reactive.model.EmployeeDto;
import com.milan.poc.reactive.model.EmployeeRequest;
import com.milan.poc.reactive.model.ResponseDto;
import com.milan.poc.reactive.repository.ReactiveEmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import org.springframework.http.codec.ServerSentEvent;

@Service
public class ReactiveEmployeeService {
	@Autowired
	private ReactiveEmployeeRepository reactiveEmployeeRepository;
	
//	public Mono<ResponseDto> fetchEmployees() {
//		Flux<Employee> employeeList = reactiveEmployeeRepository.findAll();
//		if(employeeList.count().blockOptional().isEmpty()) {
//			throw new ApiException("ERR-101","No data found");
//		}		
//		Mono<ResponseDto> response = Mono.just(new ResponseDto("success",employeeList.collectList().block()));
//		return response;
//	}
		
	public Flux<Object> fetchEmployees() {
		
		List<Employee> empList = null;
		Flux<Employee> fluxValues = reactiveEmployeeRepository.findAll();
		
//		fluxValues.blockLast(Duration.ofSeconds(1));
		
//		return fluxValues.map(e->e.getEmail());
//		return fluxValues.flatMap(e->convert(e));
//		return fluxValues.map(e->{return e;});
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5)); 
//		return Flux.interval(Duration.ofSeconds(1))
//	      .map(sequence -> ServerSentEvent.<EmployeeDto> builder()
//	        .id(String.valueOf(sequence))
//	          .event("employee-event")
//	          .data(fluxValues.map(e -> new EmployeeDto(e.getFirstName(),e.getLastName(),e.getEmail())))
//	          .build());
		
//		return fluxValues.map(it -> new EmployeeDto(it.getFirstName(),it.getLastName(),it.getEmail())).delayElements(Duration.ofSeconds(1));
		return Flux.zip(interval, fluxValues).map(tuple->
        ServerSentEvent.<Employee>builder().event("message").data(tuple.getT2()).build());
//		return fluxValues;
//		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
//		Flux<List<Employee>> response = Flux.fromStream(Stream.generate((Supplier<List<Employee>>) () -> {
//	            return getEmployees();
//	        }));
//	        return Flux.zip(interval, response).map(Tuple2::getT2);
	}
	
	private List<Employee> getEmployees(){
		 List<Employee> values = new ArrayList<>();
	        Random r = new Random();
	        int randomInt = 0;
	        for (int i = 2000; i < 2015; i += 1) {
	            randomInt = r.ints(30, (90 + 1)).limit(1).findFirst().getAsInt();
	            values.add(reactiveEmployeeRepository.findAll().blockLast());
	        }
	        return values;		
	}
	
	private static Mono<EmployeeDto> convert(Employee e)
	{
		return Mono.just(new EmployeeDto(e.getFirstName(),e.getLastName(),e.getEmail()));
	}
	
	public Mono<ResponseDto> fetchEmployee(String email) {
		Mono<Employee> employee = reactiveEmployeeRepository.findByEmail(email);
		Mono<ResponseDto> response = employee.flatMap(e->{return Mono.just(new ResponseDto("success", e));});
		return response;
	}
	
	@Transactional
	public Mono<ResponseDto> createEmployee(EmployeeRequest request) {
		Employee employee = new Employee(request.getFirstName(), request.getLastName(),request.getEmail());
		employee.setCreatedOn(new Timestamp(System.currentTimeMillis()));
		Mono<Employee> savedEmployee = reactiveEmployeeRepository.save(employee);
		Mono<ResponseDto> response = savedEmployee.flatMap(e->{return Mono.just(new ResponseDto("success", e));});
		return response;
	}
	@Transactional
	public Mono<ResponseDto> updateEmployee(EmployeeRequest request) {
		Mono<Employee> employee = reactiveEmployeeRepository.findByEmail(request.getEmail());		
		Mono<Employee> savedEmployee = reactiveEmployeeRepository.save(employee.block());
		Mono<ResponseDto> response = savedEmployee.flatMap(e->{return Mono.just(new ResponseDto("success", e));});
		return response;		
	}
}
