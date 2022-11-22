package org.hdcd.controller;

import java.util.ArrayList;
import java.util.List;

import org.hdcd.common.domain.CodeLabelValue;
import org.hdcd.common.domain.PageRequest;
import org.hdcd.common.domain.Pagination;
import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.domain.Board;
import org.hdcd.domain.Member;
import org.hdcd.service.BoardService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

	private final BoardService service;
		
	@GetMapping("/register")
	@PreAuthorize("hasRole('MEMBER')")
	public void registerForm(Model model, Authentication authentication) throws Exception {
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		
		Member member = customUser.getMember();

		Board board = new Board();

		board.setWriter(member.getUserId());

		model.addAttribute(board);
	}

	@PostMapping("/register")
	@PreAuthorize("hasRole('MEMBER')")
	public String register(@Validated Board board, BindingResult result, RedirectAttributes rttr, int groupLayer) throws Exception {
		
		if(result.hasErrors()) {
			return "board/register";
		}		
		
		// 그룹레이어
		board.setGroupLayer((long) groupLayer);
		
		//오리진 넘버도 등록하기
		if (groupLayer == 0) {
			board.setOriginNo((long) service.selectNewBoardNo(board));	
		}
		
		//등록하기
		service.register(board);

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/list";
		
	}

	@GetMapping("/registerReply")
	@PreAuthorize("hasRole('MEMBER')")
	public void registerReplyForm(Model model, Authentication authentication) throws Exception {
		
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		
		Member member = customUser.getMember();

		Board board = new Board();

		board.setWriter(member.getUserId());

		model.addAttribute(board);
	}

	@PostMapping("/registerReply")
	@PreAuthorize("hasRole('MEMBER')")
	public String registerReply(@Validated Board board, @ModelAttribute("pgrq") PageRequest pageRequest, BindingResult result, RedirectAttributes rttr, int groupLayer, int originNo) throws Exception {
		
		if(result.hasErrors()) {
			return "board/registerReply";
		}
		
		board.setGroupLayer((long) groupLayer);
		board.setOriginNo((long) originNo);
		
		//등록하기
		service.register(board);
		
		rttr.addAttribute("page", pageRequest.getPage());
	    rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/list")
	public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		model.addAttribute("list", service.list(pageRequest));
		
		Pagination pagination = new Pagination();
	    pagination.setPageRequest(pageRequest);
	    
	    pagination.setTotalCount(service.count(pageRequest));
	    
	    model.addAttribute("pagination", pagination);
	    
	    List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("n", "---"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "Title"));
		searchTypeCodeValueList.add(new CodeLabelValue("c", "Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("w", "Writer"));
		searchTypeCodeValueList.add(new CodeLabelValue("tc", "Title OR Content"));
		searchTypeCodeValueList.add(new CodeLabelValue("cw", "Content OR Writer"));
		searchTypeCodeValueList.add(new CodeLabelValue("tcw", "Title OR Content OR Writer"));

		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	}


	@GetMapping("/read")
	public void read(Long boardNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		Board board = service.read(boardNo);
		service.addHitsNo(boardNo);
		model.addAttribute(board);
	}

	@PostMapping("/remove")
	@PreAuthorize("(hasRole('MEMBER') and principal.username == #writer) or hasRole('ADMIN')")
	public String remove(Long boardNo, PageRequest pageRequest, RedirectAttributes rttr, String writer) throws Exception {		
		service.remove(boardNo);
		
		rttr.addAttribute("page", pageRequest.getPage());
	    
	    rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/list";
	}

	@GetMapping("/modify")
	@PreAuthorize("hasRole('MEMBER')")
	public void modifyForm(Long boardNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		Board board = service.read(boardNo);
		
		model.addAttribute(board);
	}

	@PostMapping("/modify")
	@PreAuthorize("hasRole('MEMBER') and principal.username == #board.writer")
	public String modify(@Validated Board board, BindingResult result, @ModelAttribute("pgrq") PageRequest pageRequest, RedirectAttributes rttr) throws Exception {
		
		if(result.hasErrors()) {
			return "board/modify";
		}		
		
		service.modify(board);
		
		rttr.addAttribute("page", pageRequest.getPage());
	    
	    rttr.addAttribute("searchType", pageRequest.getSearchType());
		rttr.addAttribute("keyword", pageRequest.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/list";
	}

}
