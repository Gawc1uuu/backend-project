package pl.zajecia.backendproject.shop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderQuantityIsTooHighException extends RuntimeException{
    private String message;

}
