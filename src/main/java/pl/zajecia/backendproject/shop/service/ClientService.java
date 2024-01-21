package pl.zajecia.backendproject.shop.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajecia.backendproject.shop.exception.UserAlreadyExistsException;
import pl.zajecia.backendproject.shop.model.Client;
import pl.zajecia.backendproject.shop.model.Product;
import pl.zajecia.backendproject.shop.model.command.ClientCommand;
import pl.zajecia.backendproject.shop.model.command.LoginCommand;
import pl.zajecia.backendproject.shop.repository.ClientRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    /*
    private String name;
    private String email;
    private String lastName;
    private LocalDate birthDate;
    private String userName;
    private String password;
    private String adress;
    private String phoneNumber;
     */

    @PostConstruct
    public void init() {
        repository.saveAndFlush(new Client("Seba","seba@gmail.com","Czerniak", LocalDate.now(),"seba","seba","Warszawa","123456789"));
        repository.saveAndFlush(new Client("Majki","majki@gmail.com","Czarnota", LocalDate.now(),"majki","majki","Warszawa","123456789"));
        repository.saveAndFlush(new Client("Gawciu","gawciu@gmail.com","Gawlik", LocalDate.now(),"gawciu","gawciu","Warszawa","123456789"));
    }
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
