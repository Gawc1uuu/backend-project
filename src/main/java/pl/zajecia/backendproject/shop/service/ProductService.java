package pl.zajecia.backendproject.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajecia.backendproject.shop.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
}
