package com.study.apiStudy.dao;

import java.util.List;

import com.study.apiStudy.dto.ArticleDto;

public interface IArticleDao {
	List<ArticleDto> articleList(String tag, int limit, int offset);
	List<ArticleDto> articleFeed(int limit, int offset);
	ArticleDto articleInsert(ArticleDto articleDto);
	ArticleDto articleSelect(String slug);
	ArticleDto articleUpdate(String slug, ArticleDto articleDto);
	String articleDelete(String slug);
	ArticleDto articleFavorite(String slug);
	ArticleDto articleUnfavorite(String slug);
	String[] tagSelectAll();
}