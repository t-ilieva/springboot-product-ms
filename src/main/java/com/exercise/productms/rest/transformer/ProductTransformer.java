package com.exercise.productms.rest.transformer;

import com.exercise.productms.data.entity.Product;
import com.exercise.productms.rest.request.ProductRequest;
import com.exercise.productms.rest.response.BrandResponse;
import com.exercise.productms.rest.response.CategoryResponse;
import com.exercise.productms.rest.response.ProductResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductTransformer {


    private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
    private final CategoryTransformer categoryTransformer;
    private final BrandTransformer brandTransformer;

    public ProductTransformer(CategoryTransformer categoryTransformer, BrandTransformer brandTransformer) {
        this.categoryTransformer = categoryTransformer;
        this.brandTransformer = brandTransformer;
    }

    public ProductResponse asProductResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setUnitPrice(product.getUnitPrice());
        productResponse.setAmount(product.getAmount());
        productResponse.setDescription(product.getDescription());
        productResponse.setDateAdded(DATE_TIME_FORMATTER.format(product.getDateAdded()));

        CategoryResponse categoryResponse =
                categoryTransformer.asCategoryResponse(product.getCategory());
        productResponse.setCategoryResponse(categoryResponse);

        BrandResponse brandResponse =
                brandTransformer.asBrandResponse(product.getBrand());
        productResponse.setBrandResponse(brandResponse);

        return productResponse;
    }

    public static Product asProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setAmount(productRequest.getAmount());
        product.setDescription(productRequest.getDescription());
        product.setDateAdded(new Date());
        product.setCategory(product.getCategory());
        product.setBrand(productRequest.getBrand());

        return product;
    }
}
