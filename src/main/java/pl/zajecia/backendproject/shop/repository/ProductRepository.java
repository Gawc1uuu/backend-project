package pl.zajecia.backendproject.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zajecia.backendproject.shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
