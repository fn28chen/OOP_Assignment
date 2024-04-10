package com.example.server.Repository;

import com.example.server.Entity.Cart;

import com.example.server.Entity.NewPair;
import com.example.server.Entity.Pair;
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
    @Query(value = "select it.id, ci.count from \n" +
            "Cart  as c inner join Cart_Item as ci \n" +
            "on ci.cart_id = c.id  inner join Item as it \n" +
            "on it.id = ci.item_id where c.id = :id and ci.status ='FALSE'", nativeQuery = true)
    List<NewPair> getAllIdItemInCart(@Param("id") Long id);
}
