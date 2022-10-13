package com.study.apiStudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.apiStudy.dao.ArticleDao;
import com.study.apiStudy.dto.ArticleDto;

@Service
public class ArticleService implements IArticleService {
	@Autowired
	ArticleDao articleDao;

	@Override
	public ArticleDto articleRegister(ArticleDto articleDto) {
		ArticleDto article = articleDao.articleInsert(articleDto);
		
		return article;
	}
	
}
