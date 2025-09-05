package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;
import com.example.demo.common.aop.PrintExecutionTime;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	@PrintExecutionTime
	public List<BoardVO> selectBoard(BoardVO boardVO) {
		return boardMapper.selectBoard(boardVO);
	}

	@Override
	public BoardVO selectBoardByBno(Long bno) {
		return boardMapper.selectBoardByBno(bno);
	}

	@Override
	public List<ReplyVO> selectReply(Long bno) {
		return boardMapper.selectReply(bno);
	}
	
	@Transactional
	@Override
	public int deleteBoard(Long bno) {
		// 댓글 삭제
		
		// 첨부파일 삭제
		
		// 게시글 삭제
		
		return boardMapper.deleteBoard(bno);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}

	@Override
	public Long selectCount(BoardVO boardVO) {
		return boardMapper.selectCount(boardVO);
	}
	
	
}
