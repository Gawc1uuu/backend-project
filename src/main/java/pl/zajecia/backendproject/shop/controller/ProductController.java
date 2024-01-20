package pl.zajecia.backendproject.shop.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.backendproject.shop.exception.ProductCannotBeEmptyException;
import pl.zajecia.backendproject.shop.exception.ProductDontExistsException;
import pl.zajecia.backendproject.shop.model.Product;
import pl.zajecia.backendproject.shop.model.command.ProductCommand;
import pl.zajecia.backendproject.shop.model.dto.ProductDto;
import pl.zajecia.backendproject.shop.reponse.ProductCannotBeEmptyResponse;
import pl.zajecia.backendproject.shop.reponse.ProductDontExistsResponse;
import pl.zajecia.backendproject.shop.service.ProductService;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductCommand command, @PathVariable Long id) {
        Product product = productService.updateProduct(id, command);
        ProductDto productDto = ProductDto.fromEntity(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> gettingProducts() {
        List<Product> products = productService.gettingProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @ExceptionHandler(ProductCannotBeEmptyException.class)
        public ResponseEntity<ProductCannotBeEmptyResponse> handleProductCannotBeEmptyException(ProductCannotBeEmptyException e) {
        return new ResponseEntity<>(new ProductCannotBeEmptyResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductDontExistsException.class)
        public ResponseEntity<ProductDontExistsResponse> handleProductDontExistsException(ProductDontExistsException e){
        return new ResponseEntity<>(new ProductDontExistsResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
