package pl.zajecia.backendproject.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.zajecia.backendproject.shop.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByEmail(String email);
    @Query("select c from Client c where c.email = :email")
    Optional<Client> findByEmail(@Param("email") String email);


}
