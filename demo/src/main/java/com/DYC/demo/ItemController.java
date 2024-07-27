package com.DYC.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String func1(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        System.out.println(result);
        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/edit")
    String editPost(Long id, String product, String description, Integer price, Integer stock, String category) {

        itemService.editItem(id, product, description, price, stock, category);
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("item", result.get());
            return "update";
        } else {
            return "error";
        }
    }

    @PostMapping("/add")
    String addPost(String product, String description, Integer price, Integer stock, String category) {

        itemService.saveItem(product, description, price, stock, category);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "detail";
        } else {
            return "error";
        }
    }
}
