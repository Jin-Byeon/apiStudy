package com.study.apiStudy.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.study.apiStudy.dto.CommentDto;

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
	public ArrayList<CommentDto> commentSelectAll(String slug) {
		ArrayList<CommentDto> multipleComments = new ArrayList<CommentDto>();
		
		for (int i = 0; i < comments.size(); i++) {
			if (comments.get(i).getSlug().equals(slug)) {
				multipleComments.add(comments.get(i));
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
