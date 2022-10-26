package com.study.apiStudy.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.study.apiStudy.dto.CommentDto;
import com.study.apiStudy.dto.SingleComment;

@Repository
public class CommentDao implements ICommentDao {
	private ArrayList<CommentDto> comments;
	
	public CommentDao() {
		comments = new ArrayList<CommentDto>();
	}

	@Override
	public CommentDto commentInsert(String slug, CommentDto commentDto) {
		CommentDto comment = new CommentDto();
		Date date = new Date();
		int idCount = 1;
		
		for (int i = 0; i < comments.size(); i++) {
			if (comments.get(i).getSlug().equals(slug)) {
				idCount++;
			}
		}
		
		comment.setSlug(slug);
		comment.setId(idCount);
		comment.setCreatedAt(date);
		comment.setUpdatedAt(date);
		comment.setBody(commentDto.getBody());
		
		comments.add(comment);
		
		return comment;
	}

	@Override
	public ArrayList<SingleComment> commentSelectAll(String slug) {
		ArrayList<SingleComment> multipleComments = new ArrayList<SingleComment>();
		
		for (int i = 0; i < comments.size(); i++) {
			if (comments.get(i).getSlug().equals(slug)) {
				SingleComment singleComment = new SingleComment();
				
				singleComment.setId(comments.get(i).getId());
				singleComment.setCreatedAt(comments.get(i).getCreatedAt());
				singleComment.setUpdatedAt(comments.get(i).getUpdatedAt());
				singleComment.setBody(comments.get(i).getBody());
				
				multipleComments.add(singleComment);
			}
		}
		
		return multipleComments;
	}

	@Override
	public String commentDelete(String slug, int id) {
		
		for (int i = 0; i < comments.size(); i++) {
			if (comments.get(i).getSlug().equals(slug) && comments.get(i).getId() == id) {
				comments.remove(i);
			}
		}
		
		return "Success";
	}
}
