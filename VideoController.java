package com.example.demo.controller;

import com.example.demo.entity.Video;
import com.example.demo.service.VideoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
    private final VideoService service;

    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Video> getAll() { return service.findAll(); }

    @PostMapping
    public Video create(@RequestBody Video v) { return service.save(v); }

    @GetMapping("/{id}")
    public Video getOne(@PathVariable Long id) { return service.findById(id); }

    @PutMapping("/{id}")
    public Video update(@PathVariable Long id, @RequestBody Video v) {
        Video exist = service.findById(id);
        if (exist != null) {
            exist.setTitle(v.getTitle());
            exist.setUrl(v.getUrl());
            exist.setCategory(v.getCategory());
            return service.save(exist);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/search")
    public List<Video> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
}
