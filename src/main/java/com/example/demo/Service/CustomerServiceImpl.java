package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository custrepo;
	
	
	
	public Mono<Customer> findById(int id){
		return custrepo.findByCustid(id);
	}
	
	public Flux<Customer> findByName(String name) {
		return custrepo.findByName(name);
	}
	
	public Flux<Customer> findAllCust(){
		return custrepo.findAll();
	}
	
	

}
