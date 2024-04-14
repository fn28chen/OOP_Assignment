package com.example.server.Repository;

import com.example.server.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query(value = "select ci.* from  Cart_Item as ci where ci.cart_id = :id", nativeQuery = true)
    List<CartItem> getCartItemsByIdCart(@Param("id") Long id);

    @Query(value = "select ci.item_id from  Cart_Item as ci where ci.cart_id = :id and ci.status = 'FALSE'", nativeQuery = true)
    List<Long> getFullIdItem(@Param("id") Long id);

    @Query(value = "select ci.count from Cart_Item as ci where ci.cart_id = :idCart and ci.item_id = :idItem", nativeQuery = true)
    Long getCount(@Param("idCart") Long idCart, @Param("idItem") Long idItem);

    @Query(value = "select * from cart_item as ci where ci.item_id = :id and ci.status ='FALSE'", nativeQuery = true)
    CartItem getCartItemsByIdItem(@Param("id") Long id);

    @Query(value = "select ci.count from Cart_Item as ci where ci.item_id = :idItem", nativeQuery = true)
    List<Long> getCounts(@Param("idItem") Long idItem);
}
