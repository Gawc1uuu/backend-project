package pl.zajecia.backendproject.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajecia.backendproject.shop.model.Client;
import pl.zajecia.backendproject.shop.model.Order;
import pl.zajecia.backendproject.shop.model.OrderItem;
import pl.zajecia.backendproject.shop.model.Product;
import pl.zajecia.backendproject.shop.model.command.OrderItemCommand;
import pl.zajecia.backendproject.shop.repository.ClientRepository;
import pl.zajecia.backendproject.shop.repository.OrderItemRepository;
import pl.zajecia.backendproject.shop.repository.OrderRepository;
import pl.zajecia.backendproject.shop.repository.ProductRepository;
import pl.zajecia.backendproject.shop.model.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public void addOrder(Long clientId, List<OrderItemCommand> orderItems) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Client with that id dont exist"));
        Order order = new Order(LocalDateTime.now(), client, 0);
        orderRepository.save(order);

        double totalPrice = 0;
        for (OrderItemCommand orderItem : orderItems) {
            Product product = productRepository.findById(orderItem.getProductId()).orElseThrow(() -> new IllegalArgumentException("Product with that id dont exist"));
            totalPrice = totalPrice + product.getPrice() * orderItem.getQuantity();
            OrderItem orderItem1 = new OrderItem(orderItem.getQuantity(), product, order);

            orderItemRepository.save(orderItem1);

            product.setQuantity(product.getQuantity() - orderItem.getQuantity());
            //TODO: sprawdzic czy mozemy zamowic taka ilosc a jesli nie to zrobic wyjatek
            productRepository.save(product);
        }
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);

    }

}
