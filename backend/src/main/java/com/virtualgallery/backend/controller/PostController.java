package com.virtualgallery.backend.controller;

import com.virtualgallery.backend.dto.PostRequest;
import com.virtualgallery.backend.dto.CommentRequest;
import com.virtualgallery.backend.model.Post;
import com.virtualgallery.backend.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> getAll(
        @RequestParam(required = false) String category,
        @RequestParam(required = false) Integer minLikes
    ) {
        boolean hasCategory = category != null && !category.isEmpty();
        boolean hasMinLikes = minLikes != null;
        if (hasCategory && hasMinLikes) {
            return postRepository.findByCategoryAndLikesGreaterThanEqual(category, minLikes);
        } else if (hasCategory) {
            return postRepository.findByCategory(category);
        } else if (hasMinLikes) {
            return postRepository.findByLikesGreaterThanEqual(minLikes);
        }
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        Optional<Post> postOpt = postRepository.findById(id);
        if (postOpt.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        return ResponseEntity.ok(postOpt.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostRequest request) {
        Post post = new Post();
        post.setArtistId(request.getArtistId());
        post.setArtistName(request.getArtistName());
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setImageUrl(request.getImageUrl());
        post.setCategory(request.getCategory());
        post.setForSale(request.isForSale());
        post.setPrice(request.getPrice());
        post.setCreatedByAI(request.isCreatedByAI());
        Post saved = postRepository.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<?> like(@PathVariable String id, @RequestParam String userId) {
        Optional<Post> postOpt = postRepository.findById(id);
        if (postOpt.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        Post post = postOpt.get();
        if (post.getLikedBy().contains(userId)) {
            post.getLikedBy().remove(userId);
        } else {
            post.getLikedBy().add(userId);
        }
        post.setLikes(post.getLikedBy().size());
        postRepository.save(post);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/{id}/save")
    public ResponseEntity<?> savePost(@PathVariable String id, @RequestParam String userId) {
        Optional<Post> postOpt = postRepository.findById(id);
        if (postOpt.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        Post post = postOpt.get();
        if (post.getSavedBy().contains(userId)) {
            post.getSavedBy().remove(userId);
        } else {
            post.getSavedBy().add(userId);
        }
        postRepository.save(post);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<?> comment(@PathVariable String id, @RequestBody CommentRequest request) {
        Optional<Post> postOpt = postRepository.findById(id);
        if (postOpt.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        Post post = postOpt.get();
        post.getCommentsList().add(new Post.Comment(request.getAuthorName(), request.getText()));
        post.setComments(post.getComments() + 1);
        postRepository.save(post);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/favorites")
    public ResponseEntity<?> favorites(@RequestParam String userId, @RequestParam(defaultValue = "all") String type) {
        List<Post> result;
        switch (type) {
            case "liked":
                result = postRepository.findByLikedByContains(userId);
                break;
            case "saved":
                result = postRepository.findBySavedByContains(userId);
                break;
            default:
                result = new java.util.ArrayList<>();
                result.addAll(postRepository.findByLikedByContains(userId));
                result.addAll(postRepository.findBySavedByContains(userId));
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id, @RequestParam String userId) {
        Optional<Post> postOpt = postRepository.findById(id);
        if (postOpt.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado");
        Post post = postOpt.get();
        if (!post.getArtistId().equals(userId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Sem permissão para excluir");
        }
        postRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
} 