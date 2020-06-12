package com.onlineApp.Controller;

import com.onlineApp.ENUM.STATUS;
import com.onlineApp.ExceptionHandler.ResourceAlreadyExistException;
import com.onlineApp.ExceptionHandler.ResourceNotFoundException;
import com.onlineApp.Model.Product;
import com.onlineApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addLaptop(@Valid @RequestBody Product product) {
        Product product1 = productService.addProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }
}
