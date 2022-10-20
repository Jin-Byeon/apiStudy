package com.study.apiStudy.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.study.apiStudy.dto.ArticleDto;

@Repository
public class ArticleDao implements IArticleDao {
	private ArrayList<ArticleDto> articles;
	
	public ArticleDao() {
		articles = new ArrayList<ArticleDto>();
	}

	@Override
	public ArticleDto articleInsert(ArticleDto articleDto) {
		ArticleDto article = new ArticleDto();
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
		
		return articles.get(articles.size() - 1);
	}

	@Override
	public ArticleDto articleSelect(String slug) {
		ArticleDto article = new ArticleDto();
		
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getSlug().equals(slug)) {
				article = articles.get(i);
			}
		}
		
		return article;
	}
}
