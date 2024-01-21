package pl.zajecia.backendproject.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zajecia.backendproject.shop.exception.UserAlreadyExistsException;
import pl.zajecia.backendproject.shop.model.Client;
import pl.zajecia.backendproject.shop.model.command.ClientCommand;
import pl.zajecia.backendproject.shop.model.command.LoginCommand;
import pl.zajecia.backendproject.shop.response.UserAlreadyExistsResponse;
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

//    TODO: dodac endpoint do pobania wszystkich zamowien danego klienta
//    TODO: dodac endpoint do pobrania ostatniego zamowienia danego klienta
//    TODO: walidacja zamowienia ilosc produktow nie moze byc wieksza niz ilosc produktow w magazynie
//    TODO: zwrocic zamoowienie po zlozeniu go
//    WEBSOCKETS
//    SWAGGER
//    DOKUMENTACJA
//    STATUS ZAMOWIENIA


}
