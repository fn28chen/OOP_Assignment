package com.example.server.Controller;

import com.example.server.DTO.ItemDTO;
import com.example.server.Entity.Category;
import com.example.server.Entity.DescriptionItem;
import com.example.server.Entity.Discount;
import com.example.server.Entity.Item;
import com.example.server.Service.CategoryService;
import com.example.server.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    CategoryService categoryService;

   

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ItemDTO itemDTO) {
        return itemService.create(mapper(itemDTO));
    }

    @GetMapping("/items/cart/{idCart}")
    public List<ItemDTO> getAllInCart(@PathVariable Long idCart) {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        List<Item> items = itemService.getAllItemInCart(idCart);
        for (Item item : items) {
            itemDTOS.add(mapperDTO(item));
        }
        return itemDTOS;
    }

    @GetMapping("get/all/{idCategory}")
    public List<ItemDTO> getAllItem(@PathVariable Long idCategory) {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        List<Item> items = itemService.getAllItemWithCategory(idCategory);
        for (Item item : items) {
            itemDTOS.add(mapperDTO(item));
        }
        return itemDTOS;
    }

    @GetMapping("/get/all")
    public List<ItemDTO> getAllItem() {
        List<ItemDTO> itemDTOS = new ArrayList<>();
        List<Item> items = itemService.getAll();
        for (Item item : items) {
            itemDTOS.add(mapperDTO(item));
        }
        return itemDTOS;
    }

    private Item mapper(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setColor(itemDTO.getColor());
        item.setSize(itemDTO.getSize());
        item.setCount(itemDTO.getCount());
        item.setImage(itemDTO.getImage());
        if (itemDTO.getCategoryDTO() != null && itemDTO.getCategoryDTO().getId() != null) {
            Category category = categoryService.getById(itemDTO.getCategoryDTO().getId());
            item.setCategory(category);
        }
        return item;
    }

    private ItemDTO mapperDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setColor(item.getColor());
        itemDTO.setImage(item.getImage());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setSize(item.getSize());
        itemDTO.setCount(item.getCount());
        return itemDTO;
    }
}
