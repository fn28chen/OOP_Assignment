package com.example.server.Common;

import com.example.server.DTO.CategoryDTO;
import com.example.server.Entity.Category;

public class MapCategory {
    public Category mapCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }
    public CategoryDTO mapCategoryDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
