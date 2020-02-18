package com.spring.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession sqlsession;
	
	@Override
	public void insertBoard(BoardVO vo) {
		sqlsession.insert("insertBoard", vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		sqlsession.update("updateBoard", vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		sqlsession.delete("deleteBoard", vo);
	}

	@Override
	public void getBoard(BoardVO vo) {
		sqlsession.selectOne("getBoard", vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return sqlsession.selectList("getBoardList", vo);
	}

}
