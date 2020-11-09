package com.kocfinans.react.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kocfinans.react.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	@Override
    void delete(Customer deleted);
}
