package com.exercise.productms.rest.controller;

import com.exercise.productms.rest.response.BrandResponse;
import com.exercise.productms.rest.response.ProductResponse;
import com.exercise.productms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductResponse>> getAll(){
        List<ProductResponse> allProducts = productService.getAll();

        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable("id") int id){
        Optional<ProductResponse> productResponse = productService.getById(id);
        if (productResponse.isEmpty()){
            return ResponseEntity.
                    notFound().
                    build();
        } else {
            return ResponseEntity.
                    ok(productResponse.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> delete(@PathVariable("id") int id){
        productService.deleteProduct(id);

        return ResponseEntity.
                noContent().
                build();
    }
}
