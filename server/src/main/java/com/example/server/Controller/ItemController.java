package com.example.server.Controller;

import com.example.server.DTO.CategoryDTO;
import com.example.server.DTO.DescriptionItemDTO;
import com.example.server.DTO.DiscountDTO;
import com.example.server.DTO.ItemDTO;
import com.example.server.Entity.Category;
import com.example.server.Entity.DescriptionItem;
import com.example.server.Entity.Discount;
import com.example.server.Entity.Item;
import com.example.server.Service.CategoryService;
import com.example.server.Service.DescriptionItemService;
import com.example.server.Service.DiscountService;
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

    @Autowired
    DiscountService discountService;

    @Autowired
    DescriptionItemService descriptionItemService;

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
    @GetMapping("get/item/{idItem}")
    public ItemDTO getItemById(@PathVariable Long idItem){
        ItemDTO itemDTO = mapperDTO(itemService.getById(idItem));
        return itemDTO;
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
        if (itemDTO.getDiscountDTO() != null && itemDTO.getDiscountDTO().getId() != null) {
            Discount discount = discountService.getById(itemDTO.getDiscountDTO().getId());
            item.setDiscount(discount);
        }
        if (itemDTO.getDescriptionItemDTO() != null && itemDTO.getDescriptionItemDTO().getId() != null) {
            DescriptionItem descriptionItem = descriptionItemService.getById(itemDTO.getDescriptionItemDTO().getId());
            item.setDescriptionItem(descriptionItem);
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
        itemDTO.setCategoryDTO(new CategoryDTO(
                item.getCategory().getId(),
                item.getCategory().getName()
        ));
        itemDTO.setDiscountDTO(new DiscountDTO(
                item.getDiscount().getId(),
                item.getDiscount().getPercent()
        ));
        itemDTO.setDescriptionItemDTO(new DescriptionItemDTO(
                item.getDescriptionItem().getId(),
                item.getDescriptionItem().getMaterial(),
                item.getDescriptionItem().getDescription(),
                item.getDescriptionItem().getForm()
        ));
        return itemDTO;
    }
}