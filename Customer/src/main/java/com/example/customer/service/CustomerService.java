package com.example.customer.service;

import java.util.List;

import com.example.customer.dto.OrderRequest;
import com.example.customer.entities.Customer;

public interface CustomerService {

	public List<Customer> getData();
	
	public Customer postData(OrderRequest orderRequest);
}
