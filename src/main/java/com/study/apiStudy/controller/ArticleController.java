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
	public HashMap<String, ArticleDto> createArticle(@RequestBody ArticleDto articleDto) {
		HashMap<String, ArticleDto> result = new HashMap<String, ArticleDto>();
		
		result.put("article", articleService.articleRegister(articleDto));
		 
		return result;
	}
	
	@RequestMapping("/articles/:slug")
	@ResponseBody
	public HashMap<String, ArticleDto> getArticle(String slug) {
		HashMap<String, ArticleDto> result  = new HashMap<String, ArticleDto>();
		
		result.put("article", articleService.articleSearch(slug));
		 
		return result ;
	}
	
	@RequestMapping(value = "/articles/:slug", method = RequestMethod.PUT)
	@ResponseBody
	public HashMap<String, ArticleDto> updateArticle(String slug, @RequestBody ArticleDto articleDto) {
		HashMap<String, ArticleDto> result  = new HashMap<String, ArticleDto>();
		
		result.put("article", articleService.articleModify(slug, articleDto));
		 
		return result ;
	}
	
	@RequestMapping(value = "/articles/:slug", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteArticle(String slug) {
		return articleService.articleRemove(slug);
	}
}
