package pl.zajecia.backendproject.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zajecia.backendproject.shop.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}