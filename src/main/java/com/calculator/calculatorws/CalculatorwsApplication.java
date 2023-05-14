package com.calculator.calculatorws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController("/api")
public class CalculatorwsApplication {

    private CalculatorClient calculatorClient;

    public CalculatorwsApplication(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(CalculatorwsApplication.class, args);
    }

    @PostMapping("/api/add")
    public int add(@RequestBody Add add) {
        AddResponse opResult = calculatorClient.getAddResponse(add.getIntA(), add.getIntB(), "http://tempuri.org/Add");
        return opResult.getAddResult();
    }

    @PostMapping("/api/subtract")
    public int subtract(@RequestBody Subtract subtractRequest) {
        SubtractResponse opResult = calculatorClient.getSubtractResponse(subtractRequest.getIntA(), subtractRequest.getIntB(), "http://tempuri.org/Subtract");
        return opResult.getSubtractResult();
    }

    @PostMapping("/api/divide")
    public double divide(@RequestBody Divide divideRequest) {
        DivideResponse opResult = calculatorClient.getDivideResponse(divideRequest.getIntA(), divideRequest.getIntB(), "http://tempuri.org/Divide");
        return opResult.getDivideResult();
    }

    @PostMapping("/api/multiply")
    public int multiply(@RequestBody Multiply multiplyRequest) {
        MultiplyResponse opResult = calculatorClient.getMultiplyResponse(multiplyRequest.getIntA(), multiplyRequest.getIntB(), "http://tempuri.org/Multiply");
        return opResult.getMultiplyResult();
    }
}
