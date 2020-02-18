package com.spring.board.dao;

import java.util.List;

import com.spring.board.vo.BoardVO;

public interface BoardDAO {

	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public void getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
}
