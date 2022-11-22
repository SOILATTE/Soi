package org.hdcd.mapper;

import java.util.List;

import org.hdcd.domain.Comment;

public interface CommentMapper {

	public List<Comment> list(Comment comment) throws Exception;
	public List<Comment> listPlus(Comment comment) throws Exception;
	public void comment(Comment commet) throws Exception;
	public void commentPlus(Comment comment) throws Exception;
	public void delComment(Comment comment) throws Exception;
}
