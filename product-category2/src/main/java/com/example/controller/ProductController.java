//ProductController.java
package com.example.controller;

import com.example.dto.ProductDTO;
import com.example.model.Product;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
 private final ProductService productService = new ProductService();

 @GetMapping
 public ResponseEntity<Page<Product>> getAllProducts(
         @RequestParam(defaultValue = "0") int page,
         @RequestParam(defaultValue = "10") int size) {
     return ResponseEntity.ok(productService.getAllProducts(PageRequest.of(page, size)));
 }

 @GetMapping("/{id}")
 public ResponseEntity<Product> getProductById(@PathVariable Long id) {
     return ResponseEntity.ok(productService.getProductById(id));
 }

 @PostMapping
 public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
     return ResponseEntity.ok(productService.createProduct(productDTO));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Product> updateProduct(
         @PathVariable Long id,
         @RequestBody ProductDTO productDTO) {
     return ResponseEntity.ok(productService.updateProduct(id, productDTO));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
     productService.deleteProduct(id);
     return ResponseEntity.ok().build();
 }
}
