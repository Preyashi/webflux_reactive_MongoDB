package com.example.demo.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, Void>{

	@Query("{ 'cistid' : ?0 }")
	Mono<Customer> findByCustid(int id);
	
	@Query("{ 'name' : ?0 }")
	Flux<Customer> findByName(String name);
	
	
	
}
