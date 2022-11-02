package com.study.apiStudy.dto;

public class ArticleDto {
	private String slug;
	private String title;
	private String description;
	private String body;
	private String[] tagList;
	private String createdAt; 
	private String updatedAt;
	private boolean favorited;
	private int favoritesCount;
	
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String[] getTagList() {
		return tagList;
	}
	public void setTagList(String[] tagList) {
		this.tagList = tagList;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public boolean isFavorited() {
		return favorited;
	}
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	public int getFavoritesCount() {
		return favoritesCount;
	}
	public void setFavoritesCount(int favoritesCount) {
		this.favoritesCount = favoritesCount;
	}
}
