package com.matheusrangel.grpcdemoclient.controller;

import com.matheusrangel.grpcdemoclient.service.NetSalaryServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetSalaryController {

    private final NetSalaryServiceClient netSalaryServiceClient;

    public NetSalaryController(NetSalaryServiceClient netSalaryServiceClient) {
        this.netSalaryServiceClient = netSalaryServiceClient;
    }

    // Endpoint used only for testing directly on browser
    @GetMapping("/net-salary/calculate/{grossSalary}")
    public ResponseEntity<Double> calculate(
            @PathVariable("grossSalary") double grossSalary) {
        double netSalary = netSalaryServiceClient.calculate(grossSalary);

        return ResponseEntity.ok(netSalary);
    }
}
