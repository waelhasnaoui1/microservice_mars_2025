package com.product.product_service.controllers;

import com.product.product_service.dto.ProductRequest;
import com.product.product_service.dto.ProductResponse;
import com.product.product_service.entities.Product;
import com.product.product_service.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest product) throws Exception {

        ProductResponse productResponse = productService.addProduct(product);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        List<ProductResponse> productResponses = new ArrayList<>();
        products.forEach(product -> {
            productResponses.add(new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getCategory().getCategory_id(),
                    product.getQuantity()
            ));
        });

        return ResponseEntity.ok(productResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(new ProductResponse(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(),
                product.getCategory().getCategory_id(),
                product.getQuantity()));
    }


}
