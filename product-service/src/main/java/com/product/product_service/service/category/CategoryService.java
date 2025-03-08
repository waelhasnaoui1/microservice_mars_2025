package com.product.product_service.service.category;

import com.product.product_service.dto.CategoryRequest;
import com.product.product_service.entities.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryRequest categoryDTO);

    List<Category> getAllCategories();

}
