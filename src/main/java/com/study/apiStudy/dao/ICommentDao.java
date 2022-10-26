package com.study.apiStudy.dao;

import java.util.ArrayList;

import com.study.apiStudy.dto.CommentDto;
import com.study.apiStudy.dto.SingleComment;

public interface ICommentDao {
	CommentDto commentInsert(String slug, CommentDto commentDto);
	ArrayList<SingleComment> commentSelectAll(String slug);
	String commentDelete(String slug, int id);
}
