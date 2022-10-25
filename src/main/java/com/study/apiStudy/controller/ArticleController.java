package com.study.apiStudy.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.apiStudy.dto.ArticleDto;
import com.study.apiStudy.service.ArticleService;

@Controller
@RequestMapping("/api")
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, ArticleDto> createArticle(ArticleDto articleDto) {
		HashMap<String, ArticleDto> article = new HashMap<String, ArticleDto>();
		article.put("article", articleService.articleRegister(articleDto));
		 
		return article;
	}
	
	@RequestMapping("/articles/:slug")
	@ResponseBody
	public HashMap<String, ArticleDto> readArticle(String slug) {
		HashMap<String, ArticleDto> article = new HashMap<String, ArticleDto>();
		article.put("article", articleService.articleSearch(slug));
		 
		return article;
	}
	
	@RequestMapping(value = "/articles/:slug", method = RequestMethod.PUT)
	@ResponseBody
	public HashMap<String, ArticleDto> updateArticle(String slug, @RequestBody ArticleDto articleDto) {
		HashMap<String, ArticleDto> article = new HashMap<String, ArticleDto>();
		article.put("article", articleService.articleModify(slug, articleDto));
		 
		return article;
	}
	
	@RequestMapping(value = "/articles/:slug", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteArticle(String slug) {
		return articleService.articleRemove(slug);
	}
}
