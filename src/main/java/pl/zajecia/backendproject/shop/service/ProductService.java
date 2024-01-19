package pl.zajecia.backendproject.shop.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.zajecia.backendproject.shop.model.Product;
import pl.zajecia.backendproject.shop.model.command.ProductCommand;
import pl.zajecia.backendproject.shop.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public void addProduct(ProductCommand command) {
        Product product = new Product(command.getName(), command.getPrice(), command.getQuantity());
        repository.saveAndFlush(product);
    }

    public Product findById(Long id){
        return repository.findById(id).orElseThrow(()->new IllegalArgumentException("cannot find product"));
    }

    public Product updateProduct(Long id, ProductCommand command){
       Product product = repository.findById(id).orElseThrow(()->new IllegalArgumentException("cannot find product"));
       product.setName(command.getName());
       product.setPrice(command.getPrice());
       product.setQuantity(command.getQuantity());
       repository.saveAndFlush(product);
       return product;
    }

    public List<Product> gettingProducts(){
        List<Product> products = repository.findAll();
        return products;
    }
}
