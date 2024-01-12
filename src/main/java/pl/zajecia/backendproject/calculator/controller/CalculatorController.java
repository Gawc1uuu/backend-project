package pl.zajecia.backendproject.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zajecia.backendproject.calculator.command.CalculatorCommand;
import pl.zajecia.backendproject.calculator.response.CalculatorResponse;
import pl.zajecia.backendproject.calculator.service.CalculatorService;

@RestController
@RequestMapping("/api/v1/calculate")
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;


    @PostMapping
    public ResponseEntity<CalculatorResponse> calculate(@RequestBody CalculatorCommand command){

        double result = calculatorService.calculate(command);

        return new ResponseEntity<>(new CalculatorResponse(result), HttpStatus.ACCEPTED);
    }




}
