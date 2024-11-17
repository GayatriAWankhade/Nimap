//CategoryController.java
package com.example.controller;

import com.example.dto.CategoryDTO;
import com.example.model.Category;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
 private final CategoryService categoryService = new CategoryService();

 @GetMapping
 public ResponseEntity<Page<Category>> getAllCategories(
         @RequestParam(defaultValue = "0") int page,
         @RequestParam(defaultValue = "10") int size) {
     return ResponseEntity.ok(categoryService.getAllCategories(PageRequest.of(page, size)));
 }

 @GetMapping("/{id}")
 public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
     return ResponseEntity.ok(categoryService.getCategoryById(id));
 }

 @PostMapping
 public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO) {
     return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Category> updateCategory(
         @PathVariable Long id,
         @RequestBody CategoryDTO categoryDTO) {
     return ResponseEntity.ok(categoryService.updateCategory(id, categoryDTO));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
     categoryService.deleteCategory(id);
     return ResponseEntity.ok().build();
 }
}
