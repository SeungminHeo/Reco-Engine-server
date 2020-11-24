package com.jolp.reco_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/health", produces = "application/json")
public class HealthCheckController {
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("ok");
    }
}