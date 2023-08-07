package com.decimal.springsecurity.rest.service;

import com.decimal.springsecurity.rest.model.entity.Product;
import com.decimal.springsecurity.rest.model.request.AddProduct;
import com.decimal.springsecurity.rest.model.response.ProductDto;

import java.util.UUID;

public interface ProductService {

    ProductDto gitById(UUID id);

    ProductDto addProduct(AddProduct productRequest);
}
