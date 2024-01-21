package pl.zajecia.backendproject.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajecia.backendproject.shop.exception.InvalidCredentialsException;
import pl.zajecia.backendproject.shop.exception.UserAlreadyExistsException;
import pl.zajecia.backendproject.shop.exception.UserNotFoundException;
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
        Client client = new Client(command.getName(), command.getEmail(), command.getLastName(), command.getBirthDate(), command.getUserName(), command.getPassword(), command.getAdress(), command.getPhoneNumber());
        repository.saveAndFlush(client);

    }

    public Client login(LoginCommand command) {
        Client client = repository.findByEmail(command.getEmail()).orElseThrow(() -> new UserNotFoundException("User with that email doesnt exist", command.getEmail()));
        if (!client.getPassword().equals(command.getPassword())) {
            throw new InvalidCredentialsException("Bad password");
        }

        return client;
    }
    public void deleteClient(ClientCommand command) {
        Client client = repository.findByEmail(command.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User with this email does not exist.", command.getEmail()));
        repository.delete(client);
    }
    public void updateClient(ClientCommand command) {
        Client client = repository.findByEmail(command.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User with this email does not exist.", command.getEmail()));
        client.setName(command.getName());
        client.setLastName(command.getLastName());
        client.setBirthDate(command.getBirthDate());
        client.setUserName(command.getUserName());
        client.setPassword(command.getPassword());
        client.setAdress(command.getAdress());
        client.setPhoneNumber(command.getPhoneNumber());
        repository.saveAndFlush(client);

    }

}
