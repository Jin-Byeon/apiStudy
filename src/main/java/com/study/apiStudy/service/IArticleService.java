package com.study.apiStudy.service;

import java.util.List;

import com.study.apiStudy.dto.ArticleDto;

public interface IArticleService {
	List<ArticleDto> articleList(String tag, int limit, int offset);
	List<ArticleDto> articleFeed(int limit, int offset);
	ArticleDto articleRegister(ArticleDto articleDto);
	ArticleDto articleSearch(String slug);
	ArticleDto articleModify(String slug, ArticleDto articleDto);
	String articleRemove(String slug);
	ArticleDto articleFavorite(String slug);
	ArticleDto articleUnfavorite(String slug);
	String[] tagSearchAll();
}
