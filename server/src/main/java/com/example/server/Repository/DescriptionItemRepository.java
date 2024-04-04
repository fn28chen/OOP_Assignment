package com.example.shop.Repository;

import com.example.shop.Entity.Category;
import com.example.shop.Entity.DescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionItemRepository extends JpaRepository<DescriptionItem, Long> {

    @Query("select d from  DescriptionItem as d where d.id = :id")
    DescriptionItem getDescriptionItemId(@Param("id") Long id);
}
