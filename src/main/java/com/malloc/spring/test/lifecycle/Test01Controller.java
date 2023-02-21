package com.malloc.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lifecycle/test01")
public class Test01Controller {
	
	@ResponseBody
	@RequestMapping("/1")
	public String stringResponse() {
		
		return "<h1>테스트 프로젝트 완성</h1><h4>해당 프로젝트를 통해서 문제 풀이를 진행합니다.</h4>";
	}
	
	
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Integer> mapResponse() {
		
		Map<String, Integer> grade = new HashMap<>();
		
		grade.put("국어", 80);
		grade.put("수학", 90);
		grade.put("영어", 85);
		
		return grade;
	}
}
