package com.DYC.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String func1(Model model){
        //List<Item> result = itemRepository.findAll();
        //model.addAttribute("items", result);
        //System.out.println(result.get(0));
        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String product, String description, Integer price, Integer stock, String category) {
        System.out.println(product);
        System.out.println(description);
        System.out.println(price);
        System.out.println(stock);
        System.out.println(category);

        Item item = new Item();
        item.product = product;
        item.description = description;
        item.price = price;
        item.stock = stock;
        item.category = category;

        Item saved = itemRepository.save(item);
        System.out.println(saved.toString());
        return "redirect:/list";
    }
}
