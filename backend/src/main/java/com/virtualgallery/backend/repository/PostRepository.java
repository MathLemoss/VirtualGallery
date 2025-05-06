package com.virtualgallery.backend.repository;

import com.virtualgallery.backend.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
    java.util.List<Post> findByLikedByContains(String userId);
    java.util.List<Post> findBySavedByContains(String userId);
    java.util.List<Post> findByCategory(String category);
    java.util.List<Post> findByLikesGreaterThanEqual(int minLikes);
    java.util.List<Post> findByCategoryAndLikesGreaterThanEqual(String category, int minLikes);
} 