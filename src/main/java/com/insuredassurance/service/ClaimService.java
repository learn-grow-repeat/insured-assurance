package com.insuredassurance.service;

import com.insuredassurance.dao.ClaimDao;
import com.insuredassurance.dto.claim.ClaimResponse;
import com.insuredassurance.dto.claim.SubmitClaimRequest;
import com.insuredassurance.entity.Claim;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClaimService {

    private final ClaimDao claimDao;

    public ClaimService(ClaimDao claimDao) {
        this.claimDao = claimDao;
    }

    @Transactional
    public ClaimResponse submit(SubmitClaimRequest req) {
        Claim c = new Claim();
        c.setDescription(req.getDescription());
        c.setClaimAmount(req.getClaimAmount());

        Claim saved = claimDao.submit(req.getPolicyId(), c);
        return toResponse(saved);
    }

    public ClaimResponse get(Long claimId) {
        return toResponse(claimDao.getById(claimId));
    }

    public List<ClaimResponse> listByPolicy(Long policyId) {
        return claimDao.listByPolicy(policyId).stream().map(this::toResponse).toList();
    }

    private ClaimResponse toResponse(Claim c) {
        return new ClaimResponse(
                c.getId(),
                c.getPolicy().getId(),
                c.getDescription(),
                c.getClaimAmount(),
                c.getSubmittedAt(),
                c.getStatus()
        );
    }
}
