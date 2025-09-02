package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Paging;

@Controller
public class BoardController {
	
	@Autowired BoardMapper boardMapper;
	
	@GetMapping("boardList")
	public String BoardList(Model model, BoardVO boardVO, Paging paging) {
		paging.setTotalRecord(boardMapper.selectCount(boardVO));
		paging.setPageUnit(5);
		boardVO.setFirst(paging.getFirst());
		boardVO.setLast(paging.getLast());
		
		model.addAttribute("boardList", boardMapper.selectBoard(boardVO));
		return "boardList";
	}
	
	@GetMapping("board")
	public String Board(Model model, @RequestParam("bno") Long bno) {
		model.addAttribute("board", boardMapper.selectBoardByBno(bno));
		model.addAttribute("replyList", boardMapper.selectReply(bno));
		return "board";
	}
}
