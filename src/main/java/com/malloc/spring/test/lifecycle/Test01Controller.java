package com.malloc.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01Controller {
	
	@ResponseBody
	@RequestMapping("/lifecycle/test01/1")
	public String testProject() {
		
		return "<h1>테스트 프로젝트 완성</h1>해당 프로젝트를 통해서 문제 풀이를 진행합니다.";
	}
	
	
	@ResponseBody
	@RequestMapping("/lifecycle/test01/2")
	public Map<String, Integer> mapPrint() {
		
		Map<String, Integer> grade = new HashMap<>();
		
		grade.put("국어", 80);
		grade.put("영어", 90);
		grade.put("수학", 85);
		
		return grade;
	}
}
