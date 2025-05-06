package com.virtualgallery.backend.dto;

public class CommentRequest {
    private String authorName;
    private String text;

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
} 