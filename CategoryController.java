package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAll() { return service.findAll(); }

    @PostMapping
    public Category create(@RequestBody Category c) { return service.save(c); }

    @GetMapping("/{id}")
    public Category getOne(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category c) {
        Category exist = service.findById(id);
        if (exist != null) {
            exist.setName(c.getName());
            exist.setDescription(c.getDescription());
            return service.save(exist);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/search")
    public List<Category> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
}
