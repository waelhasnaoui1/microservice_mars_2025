package com.product.product_service.service.category;

import com.product.product_service.dto.CategoryRequest;
import com.product.product_service.entities.Category;
import com.product.product_service.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService{


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(CategoryRequest categoryDTO) {

        Category category = new Category();
        category.setName(category.getName());
        category.setDescription(category.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
