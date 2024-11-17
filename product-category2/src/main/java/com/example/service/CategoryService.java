//CategoryService.java
package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.model.Category;
import com.example.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CategoryService {
 private final CategoryRepository categoryRepository = null;

 public Page<Category> getAllCategories(Pageable pageable) {
     return categoryRepository.findAll(pageable);
 }

 public Category getCategoryById(Long id) {
     return categoryRepository.findById(id)
             .orElseThrow();
 }

 public Category createCategory(CategoryDTO categoryDTO) {
     Category category = new Category();
     category.setName(categoryDTO.getName());
     category.setDescription(categoryDTO.getDescription());
     return categoryRepository.save(category);
 }

 public Category updateCategory(Long id, CategoryDTO categoryDTO) {
     Category category = getCategoryById(id);
     category.setName(categoryDTO.getName());
     category.setDescription(categoryDTO.getDescription());
     return categoryRepository.save(category);
 }

 public void deleteCategory(Long id) {
     categoryRepository.deleteById(id);
   //  categoryRepository.deleteById(id);


 }
}
