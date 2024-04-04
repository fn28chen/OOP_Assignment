package com.example.server.Service.Implement;

import com.example.server.Entity.Item;
import com.example.server.Repository.ItemRepository;
import com.example.server.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryService categoryService;
    @Autowired
    DiscountService discountService;
    @Autowired
    DescriptionItemService descriptionItemService;

    @Autowired
    CartItemService  cartItemService;

    @Override
    public ResponseEntity<?> create(Item item){
        itemRepository.save(item);
        return new ResponseEntity<>("Create Item success", HttpStatus.CREATED);
    }

    @Override
    public Item getById(Long idItem){
        return itemRepository.getItemById(idItem);
    }
    @Override
    public List<Item> getAllItemInCart(Long id) {
        List<Long> idItems  = cartItemService.getFullIdItem(id);
        List<Item> items = new ArrayList<>();
        for (Long idItem : idItems){
            Item item = getById(idItem);
            items.add(item);
        }
        return items;
    }
    public List<Item> getAllItemWithCategory(Long idCategory){
        return itemRepository.getAllItemWithCategoryId(idCategory);
    }
    @Override
    public List<Item> getAll(){
        return itemRepository.getAllItem();
    }

}
