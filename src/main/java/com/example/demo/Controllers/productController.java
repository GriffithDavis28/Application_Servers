package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Product;
import com.example.demo.Services.ProductService;

@RestController
@RequestMapping("/products")
public class productController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id )
    {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        
        return productService.updateProduct(id, product);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id)
    {
        productService.deleteProduct(id);
    }
}
