package com.study.apiStudy.controller;

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
	public ArticleDto createArticle(ArticleDto articleDto) {
		return articleService.articleRegister(articleDto);
	}
	
	@RequestMapping("/articles/:slug")
	@ResponseBody
	public ArticleDto readArticle(String slug) {
		return articleService.articleSearch(slug);
	}
	
	@RequestMapping(value = "/articles/:slug", method = RequestMethod.PUT)
	@ResponseBody
	public ArticleDto updateArticle(String slug, @RequestBody ArticleDto articleDto) {
		return articleService.articleModify(slug, articleDto);
	}
}
