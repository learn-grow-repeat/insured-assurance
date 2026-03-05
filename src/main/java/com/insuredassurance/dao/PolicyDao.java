package com.insuredassurance.dao;

import com.insuredassurance.entity.Customer;
import com.insuredassurance.entity.Policy;
import com.insuredassurance.exception.NotFoundException;
import com.insuredassurance.repository.CustomerRepository;
import com.insuredassurance.repository.PolicyRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PolicyDao {

    private final PolicyRepository policyRepository;
    private final CustomerRepository customerRepository;

    public PolicyDao(PolicyRepository policyRepository, CustomerRepository customerRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
    }

    public Policy create(Long customerId, Policy policy) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("Customer not found: " + customerId));

        policy.setCustomer(customer);
        policy.setPolicyNumber("POL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());

        return policyRepository.save(policy);
    }

    public Policy getById(Long policyId) {
        return policyRepository.findById(policyId)
                .orElseThrow(() -> new NotFoundException("Policy not found: " + policyId));
    }

    public List<Policy> listByCustomer(Long customerId) {
        return policyRepository.findByCustomerId(customerId);
    }
}
