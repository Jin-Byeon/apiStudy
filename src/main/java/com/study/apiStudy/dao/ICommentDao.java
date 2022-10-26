package com.study.apiStudy.dao;

import java.util.ArrayList;

import com.study.apiStudy.dto.CommentDto;

public interface ICommentDao {
	CommentDto commentInsert(String slug, CommentDto commentDto);
	ArrayList<CommentDto> commentSelectAll(String slug);
	String commentDelete(String slug, int id);
}
