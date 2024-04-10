package com.example.server.Repository;

import com.example.server.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT it from Item it where it.id = :id")
    Item getItemById(@Param("id") Long id);

    @Query("select it from Item as it where it.category.id = :id")
    List<Item> getAllItemWithCategoryId(@Param("id") Long id);
    @Query("select it from Item as it")
    List<Item>getAllItem();
    @Query(value = "select it.count from Item  " +
            "as it " +
            " where it.id = :id", nativeQuery = true)
    Long getCount(@Param("id") Long id);
}
