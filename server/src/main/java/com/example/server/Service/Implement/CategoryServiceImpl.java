package com.example.server.Service.Implement;

import com.example.server.Entity.Category;
import com.example.server.Repository.CategoryRepository;
import com.example.server.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<?> create(Category category){
        categoryRepository.save(category);
        return new ResponseEntity<>("Create category success", HttpStatus.CREATED);
    }

    @Override
    public Category getById(Long id){
        return categoryRepository.getCategoryId(id);
    }

    @Override
    public ResponseEntity<?> update(Category category){
        Category category1 = categoryRepository.getCategoryId(category.getId());
        category1.setName(category.getName());
        return new ResponseEntity<>("Up date category success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Long id){
        categoryRepository.deleteById(id);
        return new ResponseEntity<>("Delete category success", HttpStatus.OK);
    }

    @Override
    public List<Category> getAll(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
