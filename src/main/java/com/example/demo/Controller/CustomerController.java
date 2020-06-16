package com.example.demo.Controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
public class CustomerController {

	@Autowired
	CustomerService custservice;
	
	@RequestMapping(path="/cust/{custid}")
	public Mono<Customer> getCustomer(@PathVariable(required=true) int custid){
		return custservice.findById(custid);
		
	}
	
	@RequestMapping({"/cust"})
	public Flux<Customer> getCustByName(@RequestParam(required=false, name="name") Optional<String> name) {
		if(name.isPresent()) {
			return custservice.findByName(name.get());
		}
		else {
			return custservice.findAllCust();
		}
		
		
	}
	
	
}
