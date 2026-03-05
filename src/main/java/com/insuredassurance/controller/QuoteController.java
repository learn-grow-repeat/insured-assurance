package com.insuredassurance.controller;

import com.insuredassurance.dto.quote.QuoteRequest;
import com.insuredassurance.dto.quote.QuoteResponse;
import com.insuredassurance.service.QuoteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public QuoteResponse quote(@Valid @RequestBody QuoteRequest req) {
        return quoteService.quote(req);
    }
}
