package com.example.server.Controller;

import com.example.server.DTO.CategoryDTO;
import com.example.server.Entity.Category;
import com.example.server.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    
    @GetMapping("/get/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<Category> categories = categoryService.getAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories)
        {
            CategoryDTO categoryDTO = mapperDTO(category);
            categoryDTOS.add(categoryDTO);
        }
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }

    private CategoryDTO mapperDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
