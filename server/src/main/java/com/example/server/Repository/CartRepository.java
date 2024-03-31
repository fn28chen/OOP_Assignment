package com.example.server.Repository;

import com.example.server.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "select c.* from Cart as c where c.id = :id", nativeQuery = true)
    Cart findCartById(@Param("id") Long id);
    // bug cho nay  nhe
//    @Query("select c from Cart  as c inner join Cart_Item as where c.id = :id and c.status ='FALSE'")
//    Cart getAllItemInCart(@Param("id") Long id);
}
