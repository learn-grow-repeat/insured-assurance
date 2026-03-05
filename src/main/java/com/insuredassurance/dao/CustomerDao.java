package com.insuredassurance.dao;

import com.insuredassurance.entity.Customer;
import com.insuredassurance.exception.NotFoundException;
import com.insuredassurance.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDao {

    private final CustomerRepository customerRepository;

    public CustomerDao(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found: " + id));
    }

    public List<Customer> list() {
        return customerRepository.findAll();
    }
}
