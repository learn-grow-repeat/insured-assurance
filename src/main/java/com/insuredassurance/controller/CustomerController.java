package com.insuredassurance.controller;

import com.insuredassurance.dto.customer.CreateCustomerRequest;
import com.insuredassurance.dto.customer.CustomerResponse;
import com.insuredassurance.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponse create(@Valid @RequestBody CreateCustomerRequest req) {
        return customerService.create(req);
    }

    @GetMapping("/{id}")
    public CustomerResponse get(@PathVariable Long id) {
        return customerService.get(id);
    }

    @GetMapping
    public List<CustomerResponse> list() {
        return customerService.list();
    }
}
