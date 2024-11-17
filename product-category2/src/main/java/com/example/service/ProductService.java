package com.example.service;

//ProductService.java
package com.example.service;

import com.example.dto.ProductDTO;
import com.example.model.Category;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ProductService {
 private final ProductRepository productRepository;
 private final CategoryService categoryService;

 public Page<Product> getAllProducts(Pageable pageable) {
     return productRepository.findAll(pageable);
 }

 public Product getProductById(Long id) {
     return productRepository.findById(id)
             .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
 }

 public Product createProduct(ProductDTO productDTO) {
     Product product = new Product();
     updateProductFromDTO(product, productDTO);
     return productRepository.save(product);
 }

 public Product updateProduct(Long id, ProductDTO productDTO) {
     Product product = getProductById(id);
     updateProductFromDTO(product, productDTO);
     return productRepository.save(product);
 }

 private void updateProductFromDTO(Product product, ProductDTO productDTO) {
     Category category = categoryService.getCategoryById(productDTO.getCategoryId());
     product.setName(productDTO.getName());
     product.setDescription(productDTO.getDescription());
     product.setPrice(productDTO.getPrice());
     product.setCategory(category);
 }

 public void deleteProduct(Long id) {
     productRepository.deleteById(id);
 }
}
