package com.study.apiStudy.dao;

import com.study.apiStudy.dto.ArticleDto;

public interface IArticleDao {
	ArticleDto articleInsert(ArticleDto articleDto);
}