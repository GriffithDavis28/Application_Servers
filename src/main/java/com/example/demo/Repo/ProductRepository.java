package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

} 