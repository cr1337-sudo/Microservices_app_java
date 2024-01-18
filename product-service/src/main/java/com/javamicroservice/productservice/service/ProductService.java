package com.javamicroservice.productservice.service;

import com.javamicroservice.productservice.dto.ProductRequest;
import com.javamicroservice.productservice.dto.ProductResponse;
import com.javamicroservice.productservice.model.Product;
import com.javamicroservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j //Logs
public class ProductService {

    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("product saved");
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> modelProducts = productRepository.findAll();
        return modelProducts.stream().map(this::mapProductToResponse).toList();
    }

    private ProductResponse mapProductToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}


