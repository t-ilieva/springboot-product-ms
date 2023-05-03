package com.exercise.productms.services;

import com.exercise.productms.data.entity.Product;
import com.exercise.productms.data.repository.ProductRepository;
import com.exercise.productms.rest.request.ProductRequest;
import com.exercise.productms.rest.response.ProductResponse;
import com.exercise.productms.rest.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    private ProductTransformer productTransformer;


    public int createProduct(ProductRequest productRequest){
        Product product = ProductTransformer.asProduct(productRequest);
        return productRepository.save(product).getId();
    }

    public List<ProductResponse> getAll(){
        return productRepository.
                findAll().
                stream().
                map(productTransformer::asProductResponse).
                collect(Collectors.toList());
    }

    public Optional<ProductResponse> getById(int id){
        return productRepository.
                findById(id).
                map(productTransformer::asProductResponse);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

}
