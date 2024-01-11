package pl.zajecia.backendproject.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zajecia.backendproject.calculator.model.CalculatorModel;

public interface CalculatorRepository extends JpaRepository<CalculatorModel, Long> {
}
