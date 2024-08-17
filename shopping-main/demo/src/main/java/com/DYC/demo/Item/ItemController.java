package com.DYC.demo.Item;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

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

    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Long id) {
        itemRepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제완료");
    }

    @GetMapping("/list/page/{pg}")
    String getListPage(@PathVariable Integer pg, Model model) {
        Page<Item> result = itemRepository.findPageBy(PageRequest.of(pg-1, 10));
        model.addAttribute("items", result);
        System.out.println(result.getTotalPages());
        System.out.println(result.hasNext());
        return "list.html";
    }
}
