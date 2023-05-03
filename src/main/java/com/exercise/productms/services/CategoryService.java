package com.exercise.productms.services;

import com.exercise.productms.data.entity.Category;
import com.exercise.productms.data.repository.CategoryRepository;
import com.exercise.productms.rest.request.CategoryRequest;
import com.exercise.productms.rest.response.CategoryResponse;
import com.exercise.productms.rest.transformer.CategoryTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public int createCategory(CategoryRequest categoryRequest){
        Category category = CategoryTransformer.asCategory(categoryRequest);
        return categoryRepository.save(category).getId();
    }

    public List<CategoryResponse> getAll(){
        return categoryRepository.
                findAll().
                stream().
                map(CategoryTransformer::asCategoryResponse).
                collect(Collectors.toList());
    }

    public Optional<CategoryResponse> getById(int id){
        return categoryRepository.
                findById(id).
                map(CategoryTransformer::asCategoryResponse);
    }

    public Optional<CategoryResponse> getByName(String name){
        return categoryRepository.
                findByName(name).
                map(CategoryTransformer::asCategoryResponse);
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
}
