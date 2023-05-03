package com.exercise.productms.rest.controller;

import com.exercise.productms.data.entity.Brand;
import com.exercise.productms.rest.response.BrandResponse;
import com.exercise.productms.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("")
    public ResponseEntity<List<BrandResponse>> getAll(){
        List<BrandResponse> allBrands = brandService.getAll();
        return ResponseEntity.ok(allBrands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getById(@PathVariable("id") int id){
        Optional<BrandResponse> brandResponse = brandService.getById(id);
        if (brandResponse.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(brandResponse.get());
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<BrandResponse> getByName(@PathVariable("name") String name){
        Optional<BrandResponse> brandResponse = brandService.getByName(name);
        if (brandResponse.isEmpty()){
            return ResponseEntity.
                    notFound().
                    build();
        } else {
            return ResponseEntity.
                    ok(brandResponse.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BrandResponse> delete(@PathVariable("id") int id){
        brandService.deleteBrand(id);

        return ResponseEntity.
                noContent().
                build();
    }

}
