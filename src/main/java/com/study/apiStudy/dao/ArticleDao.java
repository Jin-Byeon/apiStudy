package com.study.apiStudy.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.study.apiStudy.dto.ArticleDto;

@Repository
public class ArticleDao implements IArticleDao {
	private ArrayList<ArticleDto> articles;
	private String[] tags = {"reactjs", "angularjs"};
	
	public ArticleDao() {
		articles = new ArrayList<ArticleDto>();
	}

	@Override
	public List<Object> articleFeed(int limit, int offset) {
		return articles.stream().sorted().collect(Collectors.toList());
	}

	@Override
	public ArticleDto articleInsert(ArticleDto articleDto) {
		ArticleDto article = new ArticleDto();
		
		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(articleDto.getTitle())) {
				return article;
			}
		}
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String stringDate = simpleDateFormat.format(date);
		
		article.setSlug(articleDto.getTitle().replace(' ', '-'));
		article.setTitle(articleDto.getTitle());
		article.setDescription(articleDto.getDescription());
		article.setBody(articleDto.getBody());
		article.setTagList(articleDto.getTagList());
		article.setCreatedAt(stringDate);
		article.setUpdatedAt(stringDate);
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String stringDate = simpleDateFormat.format(date);

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getSlug().equals(slug)) {
				if (articles.get(i).getTitle().equals(slug.replace('-', ' '))) {
					return article;
				}
				
				article = articles.get(i);
				if (articleDto.getTitle() != null) {
					article.setSlug(articleDto.getTitle().replace(' ', '-'));
					article.setTitle(articleDto.getTitle());
				}
				if (articleDto.getDescription() != null) article.setDescription(articleDto.getDescription());
				if (articleDto.getBody() != null) article.setBody(articleDto.getBody());
				article.setUpdatedAt(stringDate);

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

	@Override
	public ArticleDto articleFavorite(String slug) {
		ArticleDto article = new ArticleDto();

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getSlug().equals(slug)) {
				article = articles.get(i);
				article.setFavorited(true);
				article.setFavoritesCount(article.getFavoritesCount() + 1);
			}
			
			articles.set(i, article);
		}
		
		return article;
	}

	@Override
	public ArticleDto articleUnfavorite(String slug) {
		ArticleDto article = new ArticleDto();

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getSlug().equals(slug)) {
				article = articles.get(i);
				
				if (article.getFavoritesCount() == 0) {
					return article;
				} else if (article.getFavoritesCount() == 1) {
					article.setFavorited(false);
					article.setFavoritesCount(article.getFavoritesCount() - 1);
				} else if (article.getFavoritesCount() > 1) {
					article.setFavoritesCount(article.getFavoritesCount() - 1);
				}
			}
			
			articles.set(i, article);
		}
		
		return article;
	}

	@Override
	public String[] tagSelectAll() {
		return tags;
	}
}
