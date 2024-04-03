package com.example.server.Repository;

import com.example.server.Entity.Wards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WardsRepository extends JpaRepository<Wards, Long> {

    @Query(value = "select Wards  from  Wards ", nativeQuery = true)
    List<Wards> getAllWards();

    Wards findWardsById(Long id);
}
