//ProductDTO.java
package com.example.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDTO {
 private Long id;
 private String name;
 private String description;
 private BigDecimal price;
 private Long categoryId;
 private CategoryDTO category;
public Object getDescription() {
	// TODO Auto-generated method stub
	return null;
}
public Object getName() {
	// TODO Auto-generated method stub
	return null;
}
}