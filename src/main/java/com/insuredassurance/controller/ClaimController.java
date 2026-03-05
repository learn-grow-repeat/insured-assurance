package com.insuredassurance.controller;

import com.insuredassurance.dto.claim.ClaimResponse;
import com.insuredassurance.dto.claim.SubmitClaimRequest;
import com.insuredassurance.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ClaimResponse submit(@Valid @RequestBody SubmitClaimRequest req) {
        return claimService.submit(req);
    }

    @GetMapping("/{claimId}")
    public ClaimResponse get(@PathVariable Long claimId) {
        return claimService.get(claimId);
    }

    @GetMapping("/by-policy/{policyId}")
    public List<ClaimResponse> listByPolicy(@PathVariable Long policyId) {
        return claimService.listByPolicy(policyId);
    }
}
