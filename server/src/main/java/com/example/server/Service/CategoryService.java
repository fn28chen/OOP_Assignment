package com.example.server.Service;

import com.example.server.Entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public ResponseEntity<?> create(Category category);

    public Category getById(Long id);

    public ResponseEntity<?> update(Category category);

    public ResponseEntity<?> delete(Long id);

    public List<Category> getAll();
}
