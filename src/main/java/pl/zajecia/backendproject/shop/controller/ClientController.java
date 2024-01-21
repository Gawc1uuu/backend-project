package pl.zajecia.backendproject.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.backendproject.shop.exception.InvalidCredentialsException;
import pl.zajecia.backendproject.shop.exception.UserAlreadyExistsException;
import pl.zajecia.backendproject.shop.exception.UserNotFoundException;
import pl.zajecia.backendproject.shop.model.Client;
import pl.zajecia.backendproject.shop.model.command.ClientCommand;
import pl.zajecia.backendproject.shop.model.command.LoginCommand;
import pl.zajecia.backendproject.shop.reponse.InvalidCredentialsResponse;
import pl.zajecia.backendproject.shop.reponse.UserAlreadyExistsResponse;
import pl.zajecia.backendproject.shop.reponse.UserNotFoundResponse;
import pl.zajecia.backendproject.shop.service.ClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<Void> addClient(@RequestBody ClientCommand command) {

        clientService.addClient(command);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<Client> login(@RequestBody LoginCommand command) {
        Client client = clientService.login(command);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<UserAlreadyExistsResponse> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return new ResponseEntity<>(new UserAlreadyExistsResponse(e.getMessage(), e.getEmail()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<InvalidCredentialsResponse> handleInvalidCredentialsException(InvalidCredentialsException e) {
        return new ResponseEntity<>(new InvalidCredentialsResponse(e.getMessage()), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundResponse> handleUserNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(new UserNotFoundResponse(e.getMessage(), e.getEmail()), HttpStatus.BAD_REQUEST);
    }
}
