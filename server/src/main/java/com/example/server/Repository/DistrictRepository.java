package com.example.server.Repository;

import com.example.server.Entity.District;
import com.example.server.Entity.Wards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    @Query(value = "select District  from  District ", nativeQuery = true)
    List<District> getAllDistrict();

    District findDistrictById(Long id);
}
