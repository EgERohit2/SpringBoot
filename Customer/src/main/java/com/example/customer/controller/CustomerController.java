package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.OrderRequest;
import com.example.customer.entities.Customer;
import com.example.customer.serviceImplementation.BikesServiceImplementation;
import com.example.customer.serviceImplementation.CustomerServiceImplementation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImplementation customerServiceImplementation;

	@Autowired
	private BikesServiceImplementation bikesServiceImplementation;

	@PostMapping()
	public Customer postAllData(@RequestBody OrderRequest orderRequest) {
		return  customerServiceImplementation.postData(orderRequest);
		
	}
	
	@GetMapping()
	public List<Customer> getAllData(){
		return customerServiceImplementation.getData();
	}
}


//	@Autowired
//	private CustomerServiceImplementation customerServiceImplementation;
//	
//	@GetMapping()
//	public List<Customer> getAllData(){
//		return customerServiceImplementation.getAll();
//	}
//	
//	@PostMapping()
//	public Customer postAllData(@RequestBody Customer customer) {
//		 customerServiceImplementation.postData(customer);
//		return customer;
//		
//	}



//package com.example.customer.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.customer.entities.Bikes;
//import com.example.customer.serviceImplementation.BikesServiceImplementation;
//
//@RestController
//@RequestMapping("/bikes")
//public class BikesController {
//
//	@Autowired
//	private BikesServiceImplementation bikesServiceImplementation;
//	@GetMapping()
//	public List<Bikes> getAllData(){
//		return bikesServiceImplementation.getAll();
//	}
//	
//	@PostMapping()
//	public Bikes postAllData(@RequestBody Bikes bikes) {
//		return bikesServiceImplementation.postData(bikes);
//	}
//}
