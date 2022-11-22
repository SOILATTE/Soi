package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Comment;


public interface CommentService {

	public List<Comment> comments(Comment comment) throws Exception;
	public List<Comment> commentsPlus(Comment comment) throws Exception;
	public void contents(Comment comment) throws Exception;
	public void contentsPlus(Comment comment) throws Exception;
}
