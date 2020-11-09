package com.kocfinans.react.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kocfinans.react.models.Customer;
import com.kocfinans.react.repositories.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
    @RequestMapping(method=RequestMethod.POST, value="/customers")
    public Customer save(@RequestBody Customer customer) {
    	customerRepository.save(customer);

        return customer;
    }

    @RequestMapping(method=RequestMethod.GET, value="/customers")
    public Iterable<Customer> customer() {
        return customerRepository.findAll();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/customers/{id}")
    public Optional<Customer> show(@PathVariable String id) {
        return customerRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/customers/{id}")
    public Customer update(@PathVariable String id, @RequestBody Customer customer) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        Customer c = optCustomer.get();
        if(customer.getTckn() != null)
            c.setTckn(customer.getTckn());
        if(customer.getNameSurname() != null)
            c.setNameSurname(customer.getNameSurname());
        if(customer.getMonthlySalary() > 0)
            c.setMonthlySalary(customer.getMonthlySalary());
        if(customer.getPhoneNumber() != null)
            c.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(c);
        return c;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
    public String delete(@PathVariable String id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        Customer c = optCustomer.get();
        customerRepository.delete(c);
        return "";
    }

}
