package com.example.demo.ex1;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/api")
@Controller
public class Ex1Controller {
	
	@GetMapping("/sample")
	public ModelAndView sample() {
		ModelAndView mv = new ModelAndView("sample");
		mv.addObject("today", new Date());
		return mv;
	}
	
	@GetMapping("/main")
	public void main() {}
	
	// 커맨드 객체
	@GetMapping("/ex1")
	public String ex1(UserVO userVO, Model model) {
		//model.addAttribute("user", userVO);
		log.info(userVO);
		return "sample";
	}
	
	// 인덱스 배열객체
	@GetMapping("/ex2")
	public String ex2(UserListVO list) {
		log.info(list);
		return "sample";
	}
	
	// request.getParameter()
	@GetMapping("/ex3")
	public String ex3(@RequestParam String name,
					  @RequestParam(value = "userage", required = false, defaultValue = "20") Integer age) {
		log.info(name + ":" + age);
		return "sample";
	}
	
	// Map <- 모든 파라미터
	@GetMapping("/ex4")
	public String ex4(@RequestParam Map<String, Object> map) {
		log.info(map);
		return "sample";
	}
	
	//
	@GetMapping("/ex5/{name}/{age}")
	public String ex5(@PathVariable String name, @PathVariable int age) {
		log.info("path=" + name + ":" + age);
		return "sample";
	}
	
	// 첨부파일
	@PostMapping("/ex6")
	public String ex6(UserVO vo, MultipartFile pic) {
		log.info(pic.getOriginalFilename());
		log.info(pic.getSize());
		log.info(vo);
		return "sample";
	}
	
}
