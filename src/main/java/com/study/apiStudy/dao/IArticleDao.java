package com.study.apiStudy.dao;

import com.study.apiStudy.dto.ArticleDto;

public interface IArticleDao {
	ArticleDto articleInsert(ArticleDto articleDto);
	ArticleDto articleSelect(String slug);
	ArticleDto articleUpdate(String slug, ArticleDto articleDto);
	String articleDelete(String slug);
	ArticleDto articleFavorite(String slug);
	ArticleDto articleUnfavorite(String slug);
	String[] tagSelectAll();
}