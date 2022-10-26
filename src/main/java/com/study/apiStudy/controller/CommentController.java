package com.study.apiStudy.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.apiStudy.dto.CommentDto;
import com.study.apiStudy.dto.SingleComment;
import com.study.apiStudy.service.CommentService;

@Controller
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping("/articles/:slug/comments")
	@ResponseBody
	public HashMap<String, SingleComment> addComment(String slug, @RequestBody CommentDto commentDto) {
		HashMap<String, SingleComment> result = new HashMap<String, SingleComment>();
		SingleComment singleComment = new SingleComment();
		
		CommentDto comment = commentService.commentRegister(slug, commentDto);
		
		singleComment.setId(comment.getId());
		singleComment.setCreatedAt(comment.getCreatedAt());
		singleComment.setUpdatedAt(comment.getUpdatedAt());
		singleComment.setBody(comment.getBody());
		
		result.put("comment", singleComment);
		 
		return result;
	}
	
}
