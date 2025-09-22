package com.example.demo.service;

import com.example.demo.entity.Video;
import com.example.demo.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    private final VideoRepository repo;

    public VideoService(VideoRepository repo) {
        this.repo = repo;
    }

    public List<Video> findAll() { return repo.findAll(); }
    public Video save(Video v) { return repo.save(v); }
    public Video findById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
    public List<Video> search(String keyword) {
        return repo.findByTitleContainingIgnoreCase(keyword);
    }
}
