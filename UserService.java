package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() { return repo.findAll(); }
    public User save(User u) { return repo.save(u); }
    public User findById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
    public List<User> search(String keyword) {
        return repo.findByUsernameContainingIgnoreCase(keyword);
    }
}
