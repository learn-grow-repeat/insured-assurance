package com.insuredassurance.dao;

import com.insuredassurance.entity.Claim;
import com.insuredassurance.entity.Policy;
import com.insuredassurance.exception.NotFoundException;
import com.insuredassurance.repository.ClaimRepository;
import com.insuredassurance.repository.PolicyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClaimDao {

    private final ClaimRepository claimRepository;
    private final PolicyRepository policyRepository;

    public ClaimDao(ClaimRepository claimRepository, PolicyRepository policyRepository) {
        this.claimRepository = claimRepository;
        this.policyRepository = policyRepository;
    }

    public Claim submit(Long policyId, Claim claim) {
        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new NotFoundException("Policy not found: " + policyId));

        claim.setPolicy(policy);
        return claimRepository.save(claim);
    }

    public Claim getById(Long claimId) {
        return claimRepository.findById(claimId)
                .orElseThrow(() -> new NotFoundException("Claim not found: " + claimId));
    }

    public List<Claim> listByPolicy(Long policyId) {
        return claimRepository.findByPolicyId(policyId);
    }
}
