package com.example.server.Controller;

import com.example.server.DTO.ItemDTO;
import com.example.server.Entity.Item;
import com.example.server.Service.CategoryService;
import com.example.server.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
