package com.insuredassurance.dto.quote;

import com.insuredassurance.entity.PolicyType;

import java.math.BigDecimal;

public class QuoteResponse {

    private PolicyType type;
    private BigDecimal coverageAmount;
    private BigDecimal monthlyPremium;

    public QuoteResponse(PolicyType type, BigDecimal coverageAmount, BigDecimal monthlyPremium) {
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.monthlyPremium = monthlyPremium;
    }

    public PolicyType getType() { return type; }
    public BigDecimal getCoverageAmount() { return coverageAmount; }
    public BigDecimal getMonthlyPremium() { return monthlyPremium; }
}
