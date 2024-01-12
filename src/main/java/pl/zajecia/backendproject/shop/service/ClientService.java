package pl.zajecia.backendproject.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajecia.backendproject.shop.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

}
