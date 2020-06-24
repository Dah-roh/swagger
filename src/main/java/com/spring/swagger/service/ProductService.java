package com.spring.swagger.service;


import com.spring.swagger.domain.Product;
import org.springframework.stereotype.Service;


@Service
public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}