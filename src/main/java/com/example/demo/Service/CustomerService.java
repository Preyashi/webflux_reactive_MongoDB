package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CustomerService {
	
	Mono<Customer> findById(int id);
	
	Flux<Customer> findByName(String name);
	
	Flux<Customer> findAllCust();

}
