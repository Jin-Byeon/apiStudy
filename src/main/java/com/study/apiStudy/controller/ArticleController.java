package com.study.apiStudy.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.apiStudy.dto.ArticleDto;
import com.study.apiStudy.service.ArticleService;

@Controller
@RequestMapping("/api")
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping(value = "/articles", method = RequestMethod.POST)
	public ModelAndView CreateArticle(ArticleDto articleDto) {
		ArticleDto article = articleService.articleRegister(articleDto);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("slug", article.getSlug());
		modelAndView.addObject("title", article.getTitle());
		modelAndView.addObject("description", article.getDescription());
		modelAndView.addObject("body", article.getBody());
		modelAndView.addObject("tagList", Arrays.deepToString(article.getTagList()));
		modelAndView.addObject("createdAt", article.getCreatedAt());
		modelAndView.addObject("updatedAt", article.getUpdatedAt());
		modelAndView.addObject("favorited", article.isFavorited());
		modelAndView.addObject("favoritesCount", article.getFavoritesCount());
		modelAndView.setViewName("createArticle");
		
		return modelAndView;
	}
	
}
