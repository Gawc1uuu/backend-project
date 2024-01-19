package pl.zajecia.backendproject.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajecia.backendproject.shop.exception.UserAlreadyExistsException;
import pl.zajecia.backendproject.shop.model.Client;
import pl.zajecia.backendproject.shop.model.Product;
import pl.zajecia.backendproject.shop.model.command.ClientCommand;
import pl.zajecia.backendproject.shop.model.command.LoginCommand;
import pl.zajecia.backendproject.shop.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public void addClient(ClientCommand command) {
        if (repository.existsByEmail(command.getEmail())) {
            throw new UserAlreadyExistsException("User with this email already exists.", command.getEmail());
        }
        Client client = new Client(command.getName(), command.getEmail(), command.getLastName(), command.getBirthDate(), command.getUserName(), command.getPassword(), command.getPassword(), command.getPhoneNumber());
        repository.saveAndFlush(client);

    }

    public Client login(LoginCommand command) {
        Client client = repository.findByEmail(command.getEmail()).orElseThrow(() -> new IllegalArgumentException("User with that email dont exist"));
        if (!client.getPassword().equals(command.getPassword())) {
            throw new IllegalArgumentException("Bad password");
        }
        return client;
    }

}
