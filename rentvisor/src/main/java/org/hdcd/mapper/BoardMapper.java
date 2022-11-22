package org.hdcd.mapper;

import java.util.List;

import org.hdcd.common.domain.PageRequest;
import org.hdcd.domain.Board;

public interface BoardMapper {

	public void create(Board board) throws Exception;

	public int selectNewBoardNo(Board board) throws Exception;
	
	public Board read(Long boardNo) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(Long boardNo) throws Exception;

	public List<Board> list(PageRequest pageRequest) throws Exception;
	
	public int count(PageRequest pageRequest) throws Exception;

	public void updateHitsNo(Long boardNo) throws Exception;

	

}
