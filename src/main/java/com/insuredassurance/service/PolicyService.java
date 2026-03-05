package com.insuredassurance.service;

import com.insuredassurance.dao.PolicyDao;
import com.insuredassurance.dto.policy.CreatePolicyRequest;
import com.insuredassurance.dto.policy.PolicyResponse;
import com.insuredassurance.entity.Policy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyDao policyDao;

    public PolicyService(PolicyDao policyDao) {
        this.policyDao = policyDao;
    }

    @Transactional
    public PolicyResponse create(CreatePolicyRequest req) {
        Policy p = new Policy();
        p.setType(req.getType());
        p.setCoverageAmount(req.getCoverageAmount());
        p.setMonthlyPremium(req.getMonthlyPremium());

        Policy saved = policyDao.create(req.getCustomerId(), p);
        return toResponse(saved);
    }

    public PolicyResponse get(Long policyId) {
        return toResponse(policyDao.getById(policyId));
    }

    public List<PolicyResponse> listByCustomer(Long customerId) {
        return policyDao.listByCustomer(customerId).stream().map(this::toResponse).toList();
    }

    private PolicyResponse toResponse(Policy p) {
        return new PolicyResponse(
                p.getId(),
                p.getPolicyNumber(),
                p.getCustomer().getId(),
                p.getType(),
                p.getStatus(),
                p.getStartDate(),
                p.getCoverageAmount(),
                p.getMonthlyPremium()
        );
    }
}
