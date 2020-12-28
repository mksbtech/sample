package com.milan.poc.reactive.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.milan.poc.reactive.entity.Employee;

import reactor.core.publisher.Mono;

@Repository
public interface ReactiveEmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
	public Mono<Employee> findByEmail(String email);

}
