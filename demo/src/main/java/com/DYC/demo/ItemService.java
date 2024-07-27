package com.DYC.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String product, String description, Integer price, Integer stock, String category){
        Item item = new Item();
        item.product = product;
        item.description = description;
        item.price = price;
        item.stock = stock;
        item.category = category;

        Item saved = itemRepository.save(item);
        System.out.println(saved.toString());
    }

    public void editItem(Long id, String product, String description, Integer price, Integer stock, String category){
        Optional<Item> optionalItem = itemRepository.findById(id);
        Item item = optionalItem.get();
        item.product = product;
        item.description = description;
        item.price = price;
        item.stock = stock;
        item.category = category;

        Item saved = itemRepository.save(item);
        System.out.println(saved.toString());
    }
}
