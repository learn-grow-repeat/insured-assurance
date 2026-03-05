package com.insuredassurance.service;

import com.insuredassurance.dao.CustomerDao;
import com.insuredassurance.dto.customer.CreateCustomerRequest;
import com.insuredassurance.dto.customer.CustomerResponse;
import com.insuredassurance.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional
    public CustomerResponse create(CreateCustomerRequest req) {
        Customer c = new Customer();
        c.setFullName(req.getFullName());
        c.setEmail(req.getEmail());
        c.setPhone(req.getPhone());

        Customer saved = customerDao.save(c);
        return toResponse(saved);
    }

    public CustomerResponse get(Long id) {
        return toResponse(customerDao.getById(id));
    }

    public List<CustomerResponse> list() {
        return customerDao.list().stream().map(this::toResponse).toList();
    }

    private CustomerResponse toResponse(Customer c) {
        return new CustomerResponse(c.getId(), c.getFullName(), c.getEmail(), c.getPhone());
    }
}
