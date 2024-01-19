package pl.zajecia.backendproject.shop.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zajecia.backendproject.shop.model.Client;
import pl.zajecia.backendproject.shop.model.command.ClientCommand;
import pl.zajecia.backendproject.shop.model.command.LoginCommand;
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

}
