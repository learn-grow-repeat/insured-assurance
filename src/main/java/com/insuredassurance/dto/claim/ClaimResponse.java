package com.insuredassurance.dto.claim;

import com.insuredassurance.entity.ClaimStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ClaimResponse {

    private Long id;
    private Long policyId;
    private String description;
    private BigDecimal claimAmount;
    private LocalDateTime submittedAt;
    private ClaimStatus status;

    public ClaimResponse(Long id, Long policyId, String description, BigDecimal claimAmount, LocalDateTime submittedAt, ClaimStatus status) {
        this.id = id;
        this.policyId = policyId;
        this.description = description;
        this.claimAmount = claimAmount;
        this.submittedAt = submittedAt;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getPolicyId() { return policyId; }
    public String getDescription() { return description; }
    public BigDecimal getClaimAmount() { return claimAmount; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public ClaimStatus getStatus() { return status; }
}
