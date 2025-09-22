package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() { return service.findAll(); }

    @PostMapping
    public User create(@RequestBody User u) { return service.save(u); }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User u) {
        User exist = service.findById(id);
        if (exist != null) {
            exist.setUsername(u.getUsername());
            exist.setPassword(u.getPassword());
            exist.setRole(u.getRole());
            return service.save(exist);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/search")
    public List<User> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
}
