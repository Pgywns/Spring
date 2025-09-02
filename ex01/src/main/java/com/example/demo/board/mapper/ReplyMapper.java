package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.service.ReplyVO;

public interface ReplyMapper {
	// 댓글 조회
	List<ReplyVO> getList(ReplyVO replyVO);
	
	// 댓글 등록
	int insert(ReplyVO replyVO);
	
	int update(ReplyVO replyVO);
	
	int delete(Long bno);
	
	ReplyVO read(Long bno);
	
	int getCountByBno(Long bno);
}
