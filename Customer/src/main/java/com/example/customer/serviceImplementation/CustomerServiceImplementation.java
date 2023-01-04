package com.example.customer.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.OrderRequest;
import com.example.customer.entities.Customer;
import com.example.customer.repository.CustomerRespository;
import com.example.customer.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService{

	@Autowired
	private CustomerRespository customerRespository;

//	@Override
//	public List<Customer> getAll() {
//		return customerRespository.findAll();
//	}

	@Override
	public Customer postData(OrderRequest orderRequest) {
		return customerRespository.save(orderRequest.getCustomer());
		
//		Customer h = new Customer();
//			h.setName(orderRequest.getName());
//			h.setBikes(new ArrayList<>(orderRequest.getBikes()));
//			customerRespository.save(h);
//		
//		return;
	}

	@Override
	public List<Customer> getData() {
		return customerRespository.findAll();
	}
}
