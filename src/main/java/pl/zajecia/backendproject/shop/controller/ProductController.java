package pl.zajecia.backendproject.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zajecia.backendproject.shop.model.command.ProductCommand;
import pl.zajecia.backendproject.shop.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductCommand command) {
        productService.addProduct(command);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
