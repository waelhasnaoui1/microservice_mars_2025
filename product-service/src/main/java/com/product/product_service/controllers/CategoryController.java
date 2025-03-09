//package com.product.product_service.controllers;
//
//import com.product.product_service.dto.CategoryRequest;
//import com.product.product_service.entities.Category;
//import com.product.product_service.service.category.CategoryService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/categories")
//@RequiredArgsConstructor
//public class CategoryController {
//
//    private final CategoryService categoryService;
//
//    @PostMapping
//    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest category) {
//        Category categoryResponse = categoryService.createCategory(category);
//        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Category>> getAllCategories() {
//        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
//    }
//
//}
