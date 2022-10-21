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
		
		return article;
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

	@Override
	public ArticleDto articleUpdate(String slug, ArticleDto articleDto) {
		ArticleDto article = new ArticleDto();
		Date date = new Date();

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getSlug().equals(slug)) {
				article = articles.get(i);
				if (articleDto.getTitle() != null) {
					article.setSlug(articleDto.getTitle().replace(" ", "-"));
					article.setTitle(articleDto.getTitle());
				}
				if (articleDto.getDescription() != null) article.setDescription(articleDto.getDescription());
				if (articleDto.getBody() != null) article.setBody(articleDto.getBody());
				article.setUpdatedAt(date);

				articles.set(i, article);
			}
		}
		
		return article;
	}

	@Override
	public String articleDelete(String slug) {
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getSlug().equals(slug)) {
				articles.remove(i);
			}
		}
		
		return "Success";
	}
}
