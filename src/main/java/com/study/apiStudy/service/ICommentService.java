package com.study.apiStudy.service;

import java.util.ArrayList;

import com.study.apiStudy.dto.CommentDto;

public interface ICommentService {
	CommentDto commentRegister(String slug, CommentDto commentDto);
	ArrayList<CommentDto> commentSearchAll(String slug);
	String commentRemove(String slug, int id);
}
