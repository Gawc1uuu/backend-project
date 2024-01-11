package pl.zajecia.backendproject.calculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajecia.backendproject.calculator.command.CalculatorCommand;
import pl.zajecia.backendproject.calculator.repository.CalculatorRepository;

@Service
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculatorRepository repository;


    public double calculate(CalculatorCommand command) {

        if (command.getOperator().equals("+")) {
            return command.getNumber1() + command.getNumber2();
        } else if (command.getOperator().equals("-")) {
            return command.getNumber1() - command.getNumber2();
        }

        return 0;

    }

}
