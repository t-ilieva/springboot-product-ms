package com.exercise.productms.services;

import com.exercise.productms.data.entity.Brand;
import com.exercise.productms.data.repository.BrandRepository;
import com.exercise.productms.rest.request.BrandRequest;
import com.exercise.productms.rest.response.BrandResponse;
import com.exercise.productms.rest.transformer.BrandTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository, BrandTransformer brandTransformer) {
        this.brandRepository = brandRepository;
    }

    public int createBrand(BrandRequest brandRequest){
        Brand brand = BrandTransformer.asBrand(brandRequest);
        return brandRepository.save(brand).getId();
    }

    public List<BrandResponse> getAll(){
        return brandRepository.findAll().
                stream().
                map(BrandTransformer::asBrandResponse).
                collect(Collectors.toList());
    }

    public Optional<BrandResponse> getById(int id){
        return brandRepository.
                findById(id).
                map(BrandTransformer::asBrandResponse);
    }

    public Optional<BrandResponse> getByName(String name){
        return brandRepository.
                findByName(name).
                map(BrandTransformer::asBrandResponse);
    }

    public void deleteBrand(int id){
        brandRepository.deleteById(id);
    }


}
