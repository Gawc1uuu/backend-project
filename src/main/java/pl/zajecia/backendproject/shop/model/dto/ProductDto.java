package pl.zajecia.backendproject.shop.model.dto;

import lombok.Value;
import pl.zajecia.backendproject.shop.model.Product;

public record ProductDto(String name, Long price, Long quantity) {
    public static ProductDto fromEntity(Product product) {
        return new ProductDto(product.getName(), product.getPrice(), product.getQuantity());
    }
}
