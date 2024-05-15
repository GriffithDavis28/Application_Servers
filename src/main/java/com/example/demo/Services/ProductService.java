package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Product;
import com.example.demo.Repo.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository prodRepo;

    public Product createProduct(Product product)
    {
        return prodRepo.save(product);
    }

    public List<Product> getProducts()
    {
        return prodRepo.findAll();
    }

    public Product getById(int id)
    {
        Optional <Product> product = prodRepo.findById(id);
        if(product.isPresent())
        {
            return product.get();
        }
        else
        {
            throw new EntityNotFoundException("Product does not exist with the id: "+id);
        }

    }

    public Product updateProduct(int id, Product existingProduct) {
        Optional<Product> originalProd = prodRepo.findById(id);
        Product updatedProd = originalProd.get(); 
        if(originalProd.isPresent())
        {
            updatedProd.setName(existingProduct.getName());
            updatedProd.setDescription(existingProduct.getDescription());
            updatedProd.setPrice(existingProduct.getPrice());
            return prodRepo.save(updatedProd);
        }
        else
        {
            return new Product();
        }
    }

    public Product deleteProduct(int id) {
        Product prod = prodRepo.findById(id).orElse(null);
        if(prod != null)
        {
            prodRepo.deleteById(id);
            return prod;
        }else{
            return null;
        }
    }
}
