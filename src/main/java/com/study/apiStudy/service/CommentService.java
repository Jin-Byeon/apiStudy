package com.study.apiStudy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.apiStudy.dao.CommentDao;
import com.study.apiStudy.dto.CommentDto;
import com.study.apiStudy.dto.SingleComment;

@Service
public class CommentService implements ICommentService {

	@Autowired
	CommentDao commentDao;

	@Override
	public CommentDto commentRegister(String slug, CommentDto commentDto) {
		return commentDao.commentInsert(slug, commentDto);
	}

	@Override
	public ArrayList<SingleComment> commentSearchAll(String slug) {
		return commentDao.commentSelectAll(slug);
	}

	@Override
	public String commentRemove(String slug, int id) {
		return commentDao.commentDelete(slug, id);
	}
}
