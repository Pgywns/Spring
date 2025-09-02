package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.service.BoardVO;
import com.example.demo.board.service.ReplyVO;

public interface BoardMapper {
	// 건수조회
	Long selectCount(BoardVO boardVO);
	
	// 전체조회
	List<BoardVO> selectBoard(BoardVO boardVO);
	
	// 단건조회
	BoardVO selectBoardByBno(Long bno);
	
	// 댓글조회
	List<ReplyVO> selectReply(Long bno);
	
	// 삭제
	int deleteBoard(Long bno);
}

