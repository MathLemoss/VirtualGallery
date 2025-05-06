package com.virtualgallery.backend.service;

import com.virtualgallery.backend.dto.PostRequest;
import com.virtualgallery.backend.dto.CommentRequest;
import com.virtualgallery.backend.model.Post;
import com.virtualgallery.backend.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(String category, Integer minLikes) {
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

    public Post getPostById(String id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post não encontrado"));
    }

    public Post createPost(PostRequest request) {
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
        return postRepository.save(post);
    }

    public Post toggleLike(String id, String userId) {
        Post post = getPostById(id);
        if (post.getLikedBy().contains(userId)) {
            post.getLikedBy().remove(userId);
        } else {
            post.getLikedBy().add(userId);
        }
        post.setLikes(post.getLikedBy().size());
        return postRepository.save(post);
    }

    public Post toggleSave(String id, String userId) {
        Post post = getPostById(id);
        if (post.getSavedBy().contains(userId)) {
            post.getSavedBy().remove(userId);
        } else {
            post.getSavedBy().add(userId);
        }
        return postRepository.save(post);
    }

    public Post addComment(String id, CommentRequest request) {
        Post post = getPostById(id);
        post.getCommentsList().add(new Post.Comment(request.getAuthorName(), request.getText()));
        post.setComments(post.getComments() + 1);
        return postRepository.save(post);
    }

    public List<Post> getFavorites(String userId, String type) {
        List<Post> result = new ArrayList<>();
        switch (type) {
            case "liked":
                result = postRepository.findByLikedByContains(userId);
                break;
            case "saved":
                result = postRepository.findBySavedByContains(userId);
                break;
            default:
                result.addAll(postRepository.findByLikedByContains(userId));
                result.addAll(postRepository.findBySavedByContains(userId));
        }
        return result;
    }

    public void deletePost(String id, String userId) {
        Post post = getPostById(id);
        if (!post.getArtistId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Sem permissão para excluir");
        }
        postRepository.deleteById(id);
    }
} 