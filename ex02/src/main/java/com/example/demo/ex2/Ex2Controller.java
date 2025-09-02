package com.example.demo.ex2;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.ex1.UserVO;

import reactor.core.publisher.Mono;

@RequestMapping("/api")
@RestController
public class Ex2Controller {
	
	@GetMapping("/rest1")
	public UserVO rest1() {
		return new UserVO("홍길동", 20, new Date(), Arrays.asList("게임", "등산"));
	}
	
	@GetMapping("/rest2") // query String
	public UserVO rest2(UserVO userVO) {
		return userVO;
	}
	
	@PostMapping("/rest3") // json 스트링 => VO // json 스트링은 get 방식은 X
	public UserVO rest3(@RequestBody UserVO userVO) {
		return userVO;
	}
	
	@GetMapping("/rest4")
	public Map rest4() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://jsonplaceholder.typicode.com/todos/1";
		return restTemplate.getForObject(uri, Map.class);
	}
	
	@GetMapping("/rest5")
	public String getPost() {
		 WebClient webClient = WebClient.create();
		 String response = webClient.get()
		 .uri("https://jsonplaceholder.typicode.com/posts/1")
		 .retrieve()
		 .bodyToMono(String.class).block();
		return response;
		}
}
