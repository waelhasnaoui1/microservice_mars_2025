package com.product.product_service.service.product;

import com.product.product_service.dto.ProductRequest;
import com.product.product_service.dto.ProductResponse;
import com.product.product_service.entities.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest) throws IOException;

    List<Product> getAllProduct();

    Product getProductById(Long productId);
}
