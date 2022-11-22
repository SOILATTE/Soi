package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Comment;
import org.hdcd.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

	private final CommentMapper mapper;

	@Override
	public List<Comment> comments(Comment comment) throws Exception {
		return mapper.list(comment);
	}

	@Override
	public List<Comment> commentsPlus(Comment comment) throws Exception {
		return mapper.listPlus(comment);
	}

	@Override
	public void contents(Comment comment) throws Exception {
		mapper.comment(comment);
	}

	@Override
	public void contentsPlus(Comment comment) throws Exception {
		mapper.commentPlus(comment);
	}

	
		
}

