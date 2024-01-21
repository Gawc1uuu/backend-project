package pl.zajecia.backendproject.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zajecia.backendproject.shop.model.Order;
import pl.zajecia.backendproject.shop.model.command.OrderItemCommand;
import pl.zajecia.backendproject.shop.model.dto.OrderDto;
import pl.zajecia.backendproject.shop.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/clients/{clientId}")
    public ResponseEntity<OrderDto> addOrder(@PathVariable Long clientId, @RequestBody List<OrderItemCommand> orderItems) {
        orderService.addOrder(clientId, orderItems);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
