package org.axteel.alidala.controller;

import org.axteel.alidala.model.Product;
import org.axteel.alidala.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CrossOrigin
    @RequestMapping (path = "/api/product", method = RequestMethod.GET)
    public List<Product> productList() {
        return productRepository.findAll();
    }


}
