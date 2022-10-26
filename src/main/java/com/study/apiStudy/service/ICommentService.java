package com.study.apiStudy.service;

import java.util.ArrayList;

import com.study.apiStudy.dto.CommentDto;
import com.study.apiStudy.dto.SingleComment;

public interface ICommentService {
	CommentDto commentRegister(String slug, CommentDto commentDto);
	ArrayList<SingleComment> commentSearchAll(String slug);
	String commentRemove(String slug, int id);
}
