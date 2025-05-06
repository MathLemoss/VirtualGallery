package com.virtualgallery.backend.dto;

public class PostRequest {
    private String artistId;
    private String artistName;
    private String title;
    private String description;
    private String imageUrl;
    private String category;
    private boolean forSale;
    private Double price;
    private boolean createdByAI;

    // getters and setters
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

    public boolean isCreatedByAI() { return createdByAI; }
    public void setCreatedByAI(boolean createdByAI) { this.createdByAI = createdByAI; }
} 