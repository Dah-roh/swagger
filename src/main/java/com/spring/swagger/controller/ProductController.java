package com.spring.swagger.controller;

import com.spring.swagger.domain.Product;
import com.spring.swagger.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public Iterable list(Model model){
        Iterable productList = productService.listAllProducts();
        return productList;
    }

    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Product showProduct(@PathVariable Integer id, Model model){
        Product product = productService.getProductById(id);
        return product;
    }


    @ApiOperation(value = "Add a product")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }
}
