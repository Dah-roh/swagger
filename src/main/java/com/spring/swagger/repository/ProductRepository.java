package com.spring.swagger.repository;


import com.spring.swagger.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product deleteById(Integer id);

    Optional<Product> findById(Integer id);
}
