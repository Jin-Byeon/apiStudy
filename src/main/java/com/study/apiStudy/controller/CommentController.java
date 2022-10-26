package com.study.apiStudy.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.apiStudy.dto.AddComment;
import com.study.apiStudy.dto.CommentDto;
import com.study.apiStudy.dto.SingleComment;
import com.study.apiStudy.service.CommentService;

@Controller
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/articles/:slug/comments", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, SingleComment> addComment(String slug, @RequestBody AddComment addComment) {
		HashMap<String, SingleComment> result = new HashMap<String, SingleComment>();
		SingleComment singleComment = new SingleComment();
		
		CommentDto comment = commentService.commentRegister(slug, addComment.getComment());
		
		singleComment.setId(comment.getId());
		singleComment.setCreatedAt(comment.getCreatedAt());
		singleComment.setUpdatedAt(comment.getUpdatedAt());
		singleComment.setBody(comment.getBody());
		
		result.put("comment", singleComment);
		 
		return result;
	}
	
	@RequestMapping("/articles/:slug/comments")
	@ResponseBody
	public HashMap<String, ArrayList<SingleComment>> getComments(String slug) {
		HashMap<String, ArrayList<SingleComment>> result = new HashMap<String, ArrayList<SingleComment>>();
		
		result.put("comments", commentService.commentSearchAll(slug));
		
		return result;
	}
	
	@RequestMapping(value = "/articles/:slug/comments/:id", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteComment(String slug, int id) {
		return commentService.commentRemove(slug, id);
	}
}
