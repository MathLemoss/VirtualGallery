package com.virtualgallery.backend.controller;

import com.virtualgallery.backend.dto.PostRequest;
import com.virtualgallery.backend.dto.CommentRequest;
import com.virtualgallery.backend.model.Post;
import com.virtualgallery.backend.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAll(
        @RequestParam(required = false) String category,
        @RequestParam(required = false) Integer minLikes
    ) {
        return postService.getAllPosts(category, minLikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostRequest request) {
        Post saved = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<?> like(@PathVariable String id, @RequestParam String userId) {
        Post post = postService.toggleLike(id, userId);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/{id}/save")
    public ResponseEntity<?> savePost(@PathVariable String id, @RequestParam String userId) {
        Post post = postService.toggleSave(id, userId);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<?> comment(@PathVariable String id, @RequestBody CommentRequest request) {
        Post post = postService.addComment(id, request);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/favorites")
    public ResponseEntity<?> favorites(@RequestParam String userId, @RequestParam(defaultValue = "all") String type) {
        List<Post> result = postService.getFavorites(userId, type);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id, @RequestParam String userId) {
        postService.deletePost(id, userId);
        return ResponseEntity.ok().build();
    }
} 