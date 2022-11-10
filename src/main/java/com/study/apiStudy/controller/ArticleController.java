package com.study.apiStudy.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.apiStudy.dto.ArticleDto;
import com.study.apiStudy.dto.CreateArticle;
import com.study.apiStudy.dto.UpdateArticle;
import com.study.apiStudy.service.ArticleService;

@Controller
@RequestMapping("/api")
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/articles/feed")
	@ResponseBody
	public HashMap<String, List<ArticleDto>> feedArticles(@RequestParam(defaultValue = "20") int limit, @RequestParam(defaultValue = "0") int offset) {
		HashMap<String, List<ArticleDto>> result = new HashMap<String, List<ArticleDto>>();

		result.put("articles", articleService.articleFeed(limit, offset));
		
		return result;
	}
	
	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, ArticleDto> createArticle(@RequestBody CreateArticle createArticle) {
		HashMap<String, ArticleDto> result = new HashMap<String, ArticleDto>();
		
		result.put("article", articleService.articleRegister(createArticle.getArticle()));
		 
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
	public HashMap<String, ArticleDto> updateArticle(String slug, @RequestBody UpdateArticle updateArticle) {
		HashMap<String, ArticleDto> result  = new HashMap<String, ArticleDto>();
		
		result.put("article", articleService.articleModify(slug, updateArticle.getArticle()));
		 
		return result ;
	}
	
	@RequestMapping(value = "/articles/:slug", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteArticle(String slug) {
		return articleService.articleRemove(slug);
	}
	
	@RequestMapping(value = "/articles/:slug/favorite", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, ArticleDto> favorite(String slug) {
		HashMap<String, ArticleDto> result = new HashMap<String, ArticleDto>();
		
		result.put("article", articleService.articleFavorite(slug));
		
		return result;
	}
	
	@RequestMapping(value = "/articles/:slug/favorite", method = RequestMethod.DELETE)
	@ResponseBody
	public HashMap<String, ArticleDto> unfavorite(String slug) {
		HashMap<String, ArticleDto> result = new HashMap<String, ArticleDto>();
		
		result.put("article", articleService.articleUnfavorite(slug));
		
		return result;
	}
	
	@RequestMapping("/tags")
	@ResponseBody
	public HashMap<String, String[]> getTags() {
		HashMap<String, String[]> result = new HashMap<String, String[]>();
		
		result.put("tags", articleService.tagSearchAll());
		
		return result;
	}
}
