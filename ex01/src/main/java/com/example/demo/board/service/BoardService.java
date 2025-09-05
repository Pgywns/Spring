package com.example.demo.board.service;

import java.util.List;

public interface BoardService {
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
	
	// 등록
	int insertBoard(BoardVO boardVO);
}
