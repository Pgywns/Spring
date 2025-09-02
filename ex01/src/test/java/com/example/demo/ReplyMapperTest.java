package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyVO;

@SpringBootTest
public class ReplyMapperTest {
	@Autowired ReplyMapper replyMapper;
	
	@Test
	public void getList() {
		ReplyVO reply = new ReplyVO();
		reply.setBno(1L);
		reply.setFirst(1);
		reply.setLast(10);
		List<ReplyVO> list = replyMapper.getList(reply);
		list.forEach(System.out::println);
	}
	
	@Ignore
	@Test
	public void insert() {
		ReplyVO reply = new ReplyVO();
		reply.setBno(1L);
		reply.setReplyer("park");
		reply.setReply("첫번째 댓글...");
		
		int result = replyMapper.insert(reply);
		assertEquals(result, 1);
	}
}
