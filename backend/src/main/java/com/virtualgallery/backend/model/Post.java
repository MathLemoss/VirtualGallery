package com.virtualgallery.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    private String artistId;
    private String artistName;
    private String title;
    private String description;
    private String imageUrl;
    private String category;
    private boolean forSale;
    private Double price;
    private boolean createdByAI;
    private int likes;
    private int comments;
    private List<Comment> commentsList = new ArrayList<>();
    private List<String> likedBy = new ArrayList<>();
    private List<String> savedBy = new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.now();

    public Post() {}

    // getters and setters
    public boolean isCreatedByAI() { return createdByAI; }
    public void setCreatedByAI(boolean createdByAI) { this.createdByAI = createdByAI; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getArtistId() { return artistId; }
    public void setArtistId(String artistId) { this.artistId = artistId; }

    public String getArtistName() { return artistName; }
    public void setArtistName(String artistName) { this.artistName = artistName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public boolean isForSale() { return forSale; }
    public void setForSale(boolean forSale) { this.forSale = forSale; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }

    public int getComments() { return comments; }
    public void setComments(int comments) { this.comments = comments; }

    public List<Comment> getCommentsList() { return commentsList; }
    public void setCommentsList(List<Comment> commentsList) { this.commentsList = commentsList; }

    public List<String> getLikedBy() { return likedBy; }
    public void setLikedBy(List<String> likedBy) { this.likedBy = likedBy; }

    public List<String> getSavedBy() { return savedBy; }
    public void setSavedBy(List<String> savedBy) { this.savedBy = savedBy; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public static class Comment {
        private String authorName;
        private String text;
        private LocalDateTime createdAt = LocalDateTime.now();

        public Comment() {}
        public Comment(String authorName, String text) {
            this.authorName = authorName;
            this.text = text;
        }

        public String getAuthorName() { return authorName; }
        public void setAuthorName(String authorName) { this.authorName = authorName; }

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }

        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
} 