package com.customer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.customer.model.Contact;
import com.customer.model.Customer;
@Service
public class ContactServiceImpl implements ContactService {
	List<Contact> list = List.of(
			new Contact(1L, "tanya@gmail.com", "Tanya", 101L),
			new Contact(2L, "Vanya@gmail.com", "Vanya", 102L),
			new Contact(3L, "Manya@gmail.com", "Manya", 103L),
			new Contact(4L, "Sanya@gmail.com", "Sanya", 104L)
						);
	@Override
	public List<Contact> getContactofCustomer(Long cId){
		return list.stream().filter(contact -> contact.getCustomerId().equals(cId)).collect(Collectors.toList());
	}
}
