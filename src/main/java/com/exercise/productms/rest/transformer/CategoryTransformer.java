package com.exercise.productms.rest.transformer;

import com.exercise.productms.data.entity.Category;
import com.exercise.productms.rest.request.CategoryRequest;
import com.exercise.productms.rest.response.CategoryResponse;

public class CategoryTransformer {

    public static CategoryResponse asCategoryResponse(Category category){
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());

        return categoryResponse;
    }

    public static Category asCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());

        return category;
    }
}
