package com.example.server.Service;

import com.example.server.Entity.DescriptionItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DescriptionItemService {

    public DescriptionItem getById(Long id);
    public ResponseEntity<?> create(DescriptionItem descriptionItem);
    public ResponseEntity<?> delete(Long id);
    public ResponseEntity<?> update(DescriptionItem descriptionItem);
}
