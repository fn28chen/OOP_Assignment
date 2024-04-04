package com.example.server.Repository;

import com.example.server.Entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {

//    @Query("select Discount  FROM Discount where Discount .id = :id")
    Discount getDiscountById(Long id);
}
