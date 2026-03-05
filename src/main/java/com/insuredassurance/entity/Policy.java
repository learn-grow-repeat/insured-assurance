package com.insuredassurance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String policyNumber;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private PolicyType type;

    @Enumerated(EnumType.STRING)
    private PolicyStatus status = PolicyStatus.ACTIVE;

    private LocalDate startDate = LocalDate.now();

    private BigDecimal coverageAmount;
    private BigDecimal monthlyPremium;

    public Long getId() { return id; }

    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public PolicyType getType() { return type; }
    public void setType(PolicyType type) { this.type = type; }

    public PolicyStatus getStatus() { return status; }
    public void setStatus(PolicyStatus status) { this.status = status; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public BigDecimal getCoverageAmount() { return coverageAmount; }
    public void setCoverageAmount(BigDecimal coverageAmount) { this.coverageAmount = coverageAmount; }

    public BigDecimal getMonthlyPremium() { return monthlyPremium; }
    public void setMonthlyPremium(BigDecimal monthlyPremium) { this.monthlyPremium = monthlyPremium; }
}
