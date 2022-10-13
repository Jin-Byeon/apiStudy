package com.study.apiStudy.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.study.apiStudy.dto.ArticleDto;

@Repository
public class ArticleDao implements IArticleDao {
	private ArticleDto article;
	private ArrayList<ArticleDto> articles;
	
	public ArticleDao() {
		article = new ArticleDto();
		articles = new ArrayList<ArticleDto>();
	}

	@Override
	public ArticleDto articleInsert(ArticleDto articleDto) {
		Date date = new Date();
		
		article.setSlug(articleDto.getTitle().replace(" ", "-"));
		article.setTitle(articleDto.getTitle());
		article.setDescription(articleDto.getDescription());
		article.setBody(articleDto.getBody());
		article.setTagList(articleDto.getTagList());
		article.setCreatedAt(date);
		article.setUpdatedAt(date);
		article.setFavorited(false);
		article.setFavoritesCount(0);
		
		articles.add(article);
		
		return article;
	}
}
