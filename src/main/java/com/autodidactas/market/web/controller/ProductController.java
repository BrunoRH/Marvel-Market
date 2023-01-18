package com.autodidactas.market.web.controller;

import com.autodidactas.market.domain.Product;
import com.autodidactas.market.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long productId) {
        return productService.getProduct(productId);
    }
    @GetMapping("/category/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable("id") Long categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long productId){
        return productService.delete(productId);
    }
}
