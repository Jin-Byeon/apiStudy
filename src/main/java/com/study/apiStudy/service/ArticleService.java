package com.study.apiStudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.apiStudy.dao.ArticleDao;
import com.study.apiStudy.dto.ArticleDto;

@Service
public class ArticleService implements IArticleService {
	@Autowired
	ArticleDao articleDao;
	
	@Override
	public List<ArticleDto> articleFeed(int limit, int offset) {
		return articleDao.articleFeed(limit, offset);
	}

	@Override
	public ArticleDto articleRegister(ArticleDto articleDto) {
		return articleDao.articleInsert(articleDto);
	}

	@Override
	public ArticleDto articleSearch(String slug) {
		return articleDao.articleSelect(slug);
	}

	@Override
	public ArticleDto articleModify(String slug, ArticleDto articleDto) {
		return articleDao.articleUpdate(slug, articleDto);
	}

	@Override
	public String articleRemove(String slug) {
		return articleDao.articleDelete(slug);
	}

	@Override
	public ArticleDto articleFavorite(String slug) {
		return articleDao.articleFavorite(slug);
	}

	@Override
	public ArticleDto articleUnfavorite(String slug) {
		return articleDao.articleUnfavorite(slug);
	}

	@Override
	public String[] tagSearchAll() {
		return articleDao.tagSelectAll();
	}
}
