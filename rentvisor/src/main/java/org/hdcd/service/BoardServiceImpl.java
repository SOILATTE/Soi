package org.hdcd.service;

import java.util.List;

import org.hdcd.common.domain.PageRequest;
import org.hdcd.domain.Board;
import org.hdcd.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;

	@Override
	public void register(Board board) throws Exception {
		mapper.create(board);
	}
	

	@Override
	public int selectNewBoardNo(Board board) throws Exception {
		return mapper.selectNewBoardNo(board);
	}
	
	
	@Override
	public Board read(Long boardNo) throws Exception {
		return mapper.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		mapper.update(board);
	}

	@Override
	public void remove(Long boardNo) throws Exception {
		mapper.delete(boardNo);
	}

	@Override
	public List<Board> list(PageRequest pageRequest) throws Exception {
		return mapper.list(pageRequest);
	}

	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}


	@Override
	public void addHitsNo(Long boardNo) throws Exception {
		mapper.updateHitsNo(boardNo);
	}


	

}
