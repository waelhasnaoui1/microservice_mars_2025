package com.product.product_service.service.product;

import com.product.product_service.dto.ProductRequest;
import com.product.product_service.dto.ProductResponse;
import com.product.product_service.entities.Category;
import com.product.product_service.entities.Product;
import com.product.product_service.exceptions.ProductNotFoundException;
import com.product.product_service.repositories.CategoryRepository;
import com.product.product_service.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ProductResponse addProduct(ProductRequest productRequest) throws IOException {
        Optional<Category> categoryOpt = categoryRepository.findById(productRequest.categoryId());
        if(categoryOpt.isEmpty()){
            throw new IOException("Category with ID" + productRequest.categoryId() + " not found");
        }
        Category category = categoryOpt.get();

//        Product product = new Product(productRequest.name());

        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .category(category)
                .price(productRequest.price())
                .quantity(productRequest.quantity())
                .build();

        productRepository.save(product);


        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                category.getCategory_id(),
                product.getQuantity()
        );
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(()-> new ProductNotFoundException(productId));
    }
}
