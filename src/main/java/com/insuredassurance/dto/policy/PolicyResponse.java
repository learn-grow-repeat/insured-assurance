package com.insuredassurance.dto.policy;

import com.insuredassurance.entity.PolicyStatus;
import com.insuredassurance.entity.PolicyType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyResponse {

    private Long id;
    private String policyNumber;
    private Long customerId;
    private PolicyType type;
    private PolicyStatus status;
    private LocalDate startDate;
    private BigDecimal coverageAmount;
    private BigDecimal monthlyPremium;

    public PolicyResponse(Long id, String policyNumber, Long customerId, PolicyType type, PolicyStatus status,
                          LocalDate startDate, BigDecimal coverageAmount, BigDecimal monthlyPremium) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.customerId = customerId;
        this.type = type;
        this.status = status;
        this.startDate = startDate;
        this.coverageAmount = coverageAmount;
        this.monthlyPremium = monthlyPremium;
    }

    public Long getId() { return id; }
    public String getPolicyNumber() { return policyNumber; }
    public Long getCustomerId() { return customerId; }
    public PolicyType getType() { return type; }
    public PolicyStatus getStatus() { return status; }
    public LocalDate getStartDate() { return startDate; }
    public BigDecimal getCoverageAmount() { return coverageAmount; }
    public BigDecimal getMonthlyPremium() { return monthlyPremium; }
}
