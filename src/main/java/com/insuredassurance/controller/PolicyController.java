package com.insuredassurance.controller;

import com.insuredassurance.dto.policy.CreatePolicyRequest;
import com.insuredassurance.dto.policy.PolicyResponse;
import com.insuredassurance.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public PolicyResponse create(@Valid @RequestBody CreatePolicyRequest req) {
        return policyService.create(req);
    }

    @GetMapping("/{policyId}")
    public PolicyResponse get(@PathVariable Long policyId) {
        return policyService.get(policyId);
    }

    @GetMapping("/by-customer/{customerId}")
    public List<PolicyResponse> listByCustomer(@PathVariable Long customerId) {
        return policyService.listByCustomer(customerId);
    }
}
