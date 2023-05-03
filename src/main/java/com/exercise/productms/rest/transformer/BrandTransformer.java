package com.exercise.productms.rest.transformer;

import com.exercise.productms.data.entity.Brand;
import com.exercise.productms.rest.request.BrandRequest;
import com.exercise.productms.rest.response.BrandResponse;

public class BrandTransformer {

    public static BrandResponse asBrandResponse(Brand brand){
        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setId(brand.getId());
        brandResponse.setName(brand.getName());

        return brandResponse;
    }

    public static Brand asBrand(BrandRequest brandRequest){
        Brand brand = new Brand();
        brand.setName(brandRequest.getName());

        return brand;
    }
}
