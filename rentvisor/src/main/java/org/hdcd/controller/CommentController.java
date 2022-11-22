package org.hdcd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.domain.Comment;
import org.hdcd.domain.Member;
import org.hdcd.service.CommentService;
import org.hdcd.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RestController
@RequestMapping("/comment")
public class CommentController {

	private final CommentService service;
	private final MemberService memberService;
	
	@GetMapping("/add/{boardNo}")
	public ResponseEntity<List> addAndList(@PathVariable("boardNo")
	int boardNo ,HttpServletRequest request,Authentication auth) throws Exception{
		CustomUser user = (CustomUser)auth.getPrincipal();
		Member member = user.getMember();
		String userId = member.getUserId();
		long userNo = member.getUserNo();
		String content = (String)request.getParameter("contents");
		
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setUserId(userId);
		comment.setBoardNo(boardNo);
		comment.setUserNo(userNo);
		service.contents(comment);
		List comments = service.comments(comment);
		ResponseEntity<List> list = new ResponseEntity<List>(comments,HttpStatus.OK);
		return list;
	}
	
	@GetMapping("/plus/{boardNo},{commentId}")
	public ResponseEntity<List> addAndListPlus(@PathVariable("boardNo") long boardNo,
	@PathVariable("commentId") int parentId,
	HttpServletRequest request,Authentication auth)throws Exception{
		CustomUser user = (CustomUser)auth.getPrincipal();
		Member member = user.getMember();
		
		String userId = member.getUserId();
		String content = request.getParameter("content");
		
		Long userNo = member.getUserNo();
		
		Comment comments = new Comment();
		comments.setBoardNo(boardNo);
		comments.setUserId(userId);
		comments.setUserNo(userNo);
		comments.setContent(content);
		comments.setParentId(parentId);
		
		service.contentsPlus(comments);
		List<Comment> list = service.commentsPlus(comments);
		ResponseEntity<List> entity = new ResponseEntity<List>(list,HttpStatus.OK);
		return entity;
	}
}
