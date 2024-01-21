package pl.zajecia.backendproject.shop.model.dto;

import lombok.Value;
import pl.zajecia.backendproject.shop.model.Order;
import pl.zajecia.backendproject.shop.model.OrderItem;

import java.time.LocalDateTime;
import java.util.Set;

public record OrderDto(Set<OrderItem> orderItems, LocalDateTime orderDate, double totalPrice) {
    public static OrderDto fromEntity(Order order) {
        return new OrderDto(order.getOrderItems(), order.getOrderDate(), order.getTotalPrice());
    }

}
