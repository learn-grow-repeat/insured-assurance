package com.insuredassurance.dto.quote;

import com.insuredassurance.entity.PolicyType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class QuoteRequest {

    @NotNull
    private PolicyType type;

    @NotNull @Min(0)
    private BigDecimal coverageAmount;

    @NotNull @Min(18)
    private Integer customerAge;

    public PolicyType getType() { return type; }
    public void setType(PolicyType type) { this.type = type; }

    public BigDecimal getCoverageAmount() { return coverageAmount; }
    public void setCoverageAmount(BigDecimal coverageAmount) { this.coverageAmount = coverageAmount; }

    public Integer getCustomerAge() { return customerAge; }
    public void setCustomerAge(Integer customerAge) { this.customerAge = customerAge; }
}
