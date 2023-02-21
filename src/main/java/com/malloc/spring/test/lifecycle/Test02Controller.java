package com.malloc.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malloc.spring.test.lifecycle.model.Bulletin;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test02Controller {
	
	@RequestMapping("/3")
	public List<Map<String, Object>> jsonPrintMist() {
		List<Map<String, Object>> movieList = new ArrayList();
		
		Map<String, Object> movie1 = new HashMap();
		movie1.put("rate", 15);
		movie1.put("director", "봉준호");
		movie1.put("time", 131);
		movie1.put("title", "기생충");
		movieList.add(movie1);
		
		Map<String, Object> movie2 = new HashMap();
		movie2.put("rate", 0);
		movie2.put("director", "로베르토 베니니");
		movie2.put("time", 116);
		movie2.put("title", "인생은 아름다워");
		movieList.add(movie2);
		
		Map<String, Object> movie3 = new HashMap();
		movie3.put("rate", 12);
		movie3.put("director", "크리스토퍼 놀란");
		movie3.put("time", 147);
		movie3.put("title", "인셉션");
		movieList.add(movie3);
		
		return movieList;
	}
	
	@RequestMapping("/4")
	public List<Bulletin> jsonPrintClass() {
		
		List<Bulletin> bulletinList = new ArrayList();
		
		Bulletin bulletin1 = new Bulletin();
		bulletin1.setTitle("안녕하세요. 가입인사 드립니다.");
		bulletin1.setUser("hagulu");
		bulletin1.setContent("안녕하세요. 가입했어요. 잘 부탁드립니다. ");
		bulletinList.add(bulletin1);
		
		Bulletin bulletin2 = new Bulletin();
		bulletin2.setTitle("헐 대박");
		bulletin2.setUser("bada");
		bulletin2.setContent("오늘 목요일이었어...");
		bulletinList.add(bulletin2);
		
		Bulletin bulletin3 = new Bulletin();
		bulletin3.setTitle("오늘 데이트");
		bulletin3.setUser("dulumary");
		bulletin3.setContent("...");
		bulletinList.add(bulletin3);
		
		return bulletinList;
	}
}
