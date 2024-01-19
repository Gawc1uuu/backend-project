package pl.zajecia.backendproject.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajecia.backendproject.shop.model.Product;
import pl.zajecia.backendproject.shop.model.command.ProductCommand;
import pl.zajecia.backendproject.shop.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public void addProduct(ProductCommand command) {
        Product product = new Product(command.getName(), command.getPrice(), command.getQuantity());
        repository.saveAndFlush(product);
    }
}
