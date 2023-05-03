package com.exercise.productms.rest.controller;

import com.exercise.productms.data.entity.Category;
import com.exercise.productms.rest.response.CategoryResponse;
import com.exercise.productms.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getAll(){
        List<CategoryResponse> allCategories = categoryService.getAll();
        return ResponseEntity.ok(allCategories);
    }

    @GetMapping("/id")
    public ResponseEntity<Object> getById(@PathVariable("id") int id){
        Optional<CategoryResponse> categoryResponse = categoryService.getById(id);
        if (categoryResponse.isEmpty()){
            return ResponseEntity.
                    notFound().
                    build();
        } else {
            return ResponseEntity.
                    ok(categoryResponse.get());
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryResponse> getByName(@PathVariable("name") String name){
        Optional<CategoryResponse> categoryResponse = categoryService.getByName(name);
        if (categoryResponse.isEmpty()){
            return ResponseEntity.
                    notFound().
                    build();
        } else {
            return ResponseEntity.
                    ok(categoryResponse.get());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> delete(@PathVariable("id") int id){
        categoryService.deleteCategory(id);

        return ResponseEntity.
                noContent().
                build();
    }



}
