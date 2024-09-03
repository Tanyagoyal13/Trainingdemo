package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private ContactService contactService;
	
	
	List<Customer> list = List.of(
			new Customer(101L, "Tanya", "154975491"),
			new Customer(102L, "Vanya", "1549745491"),
			new Customer(103L, "Manya", "154975391"),
			new Customer(104L, "Sanya", "154975991")
			);
	@Override
	public Customer getCustomer(Long id) {
		
		Optional<Customer> customer = this.list.stream().filter(cust -> cust.getCustomerId().equals(id)).findAny();
		customer.ifPresent(c -> c.setContact(contactService.getContactofCustomer(id)) );
		return customer.orElse(null);
		}
		
}
