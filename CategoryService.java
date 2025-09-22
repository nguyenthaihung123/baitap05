package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> findAll() { return repo.findAll(); }
    public Category save(Category c) { return repo.save(c); }
    public Category findById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
    public List<Category> search(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }
}
