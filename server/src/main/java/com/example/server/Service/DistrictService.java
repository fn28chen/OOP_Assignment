package com.example.server.Service;

import com.example.server.Entity.District;
import com.example.server.Entity.Wards;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DistrictService {
    public ResponseEntity<?> createDistrict(District district);
    public List<District> getAllDistrict();
    public District getById(Long id);
}
