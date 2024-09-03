package com.store.mainstore.infrastructure.controller;

import com.store.mainstore.domain.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class ProductRestController {

    private final List<Product> products = new ArrayList<>();

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    @GetMapping("/list-products")
    public List<Product> getProducts() {
        return products;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
