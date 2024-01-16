package com.matheusrangel.grpcdemoclient.service;

import com.matheusrangel.grpcdemo.service.NetSalaryGrpc;
import com.matheusrangel.grpcdemo.service.NetSalaryRequest;
import com.matheusrangel.grpcdemo.service.NetSalaryResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class NetSalaryServiceClient {

    @GrpcClient("net-salary-grpc")
    private NetSalaryGrpc.NetSalaryBlockingStub stub;

    public double calculate(double grossSalary) {
        NetSalaryRequest request = NetSalaryRequest.newBuilder()
                .setGrossSalary(grossSalary)
                .build();

        // Call the grpc service
        NetSalaryResponse response = stub.calculate(request);

        return response.getNetSalary();
    }

}
