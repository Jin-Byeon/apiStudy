package com.study.apiStudy.service;

import com.study.apiStudy.dto.ArticleDto;

public interface IArticleService {
	ArticleDto articleRegister(ArticleDto articleDto);
	ArticleDto articleSearch(String slug);
	ArticleDto articleModify(String slug, ArticleDto articleDto);
	String articleRemove(String slug);
	ArticleDto articleFavorite(String slug);
	ArticleDto articleUnfavorite(String slug);
}
