package com.decimal.springsecurity.rest.controller;

import com.decimal.springsecurity.rest.model.request.AddProduct;
import com.decimal.springsecurity.rest.model.response.ProductDto;
import com.decimal.springsecurity.rest.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('Role 2')")
    public ProductDto addProduct(
            @Valid @RequestBody AddProduct request
    ) {
        return productService.addProduct(request);
    }

    @GetMapping("{id}")
    public ProductDto getById(@PathVariable("id") UUID id) {
        return productService.gitById(id);
    }

    @GetMapping("test")
    public String getById() {
        return "world";
    }
}
