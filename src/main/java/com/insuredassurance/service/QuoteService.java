package com.insuredassurance.service;

import com.insuredassurance.dto.quote.QuoteRequest;
import com.insuredassurance.dto.quote.QuoteResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class QuoteService {

    // Toy premium calc - replace with actuarial model later
    public QuoteResponse quote(QuoteRequest req) {
        BigDecimal baseRate;
        switch (req.getType()) {
            case LIFE -> baseRate = new BigDecimal("0.0020");
            case HEALTH -> baseRate = new BigDecimal("0.0030");
            case VEHICLE -> baseRate = new BigDecimal("0.0040");
            case HOME -> baseRate = new BigDecimal("0.0015");
            default -> baseRate = new BigDecimal("0.0030");
        }

        BigDecimal ageFactor = BigDecimal.valueOf(Math.max(1.0, req.getCustomerAge() / 40.0));
        BigDecimal monthly = req.getCoverageAmount().multiply(baseRate).multiply(ageFactor)
                .setScale(2, RoundingMode.HALF_UP);

        return new QuoteResponse(req.getType(), req.getCoverageAmount(), monthly);
    }
}
