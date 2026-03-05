package com.insuredassurance.dto.policy;

import com.insuredassurance.entity.PolicyType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CreatePolicyRequest {

    @NotNull
    private Long customerId;

    @NotNull
    private PolicyType type;

    @NotNull @Min(0)
    private BigDecimal coverageAmount;

    @NotNull @Min(0)
    private BigDecimal monthlyPremium;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public PolicyType getType() { return type; }
    public void setType(PolicyType type) { this.type = type; }

    public BigDecimal getCoverageAmount() { return coverageAmount; }
    public void setCoverageAmount(BigDecimal coverageAmount) { this.coverageAmount = coverageAmount; }

    public BigDecimal getMonthlyPremium() { return monthlyPremium; }
    public void setMonthlyPremium(BigDecimal monthlyPremium) { this.monthlyPremium = monthlyPremium; }
}
