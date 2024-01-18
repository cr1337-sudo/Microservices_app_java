package com.javamicroservice.productservice.repository;

import com.javamicroservice.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

// Repositorio que maneja productos
// El segundo parámetro String hace referencia al tipo del id.
public interface ProductRepository extends MongoRepository<Product, String> {

}
