package pl.zajecia.backendproject.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zajecia.backendproject.shop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
