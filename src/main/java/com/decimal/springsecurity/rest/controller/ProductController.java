package com.decimal.springsecurity.rest.controller;

import com.decimal.springsecurity.rest.model.Product;
import com.decimal.springsecurity.rest.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") UUID id) {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Not product found for id %s", id)
        ));
    }
}
