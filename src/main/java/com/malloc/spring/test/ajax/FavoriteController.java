package com.malloc.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.malloc.spring.test.ajax.bo.FavoriteBO;
import com.malloc.spring.test.ajax.model.Favorite;

@Controller
@RequestMapping("/ajax")
public class FavoriteController {
	
	@Autowired
	private FavoriteBO favoriteBO;
	
	@GetMapping("/list")
	public String FavoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/list";
	}
	
	@GetMapping("/input")
	public String input() {
		
		return "ajax/input";
	}
	
	//사이트 이름과 주소를 전달 받고, 데이터를 저장
	//성공 실패 여부를 response로 전달한다. 
	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> addFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url
			) {
		
		int count = favoriteBO.getAddFavorite(name, url);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1)
		{
			resultMap.put("result", "success");
		}
		else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
//		return "redirect:/ajax/list";
		
//		return "삽입결과: " + count;
	}
	
	//즐겨찾기 주소를 전달 받고, 해당 주소가 중복되었는지 확인한다.
	//중복여부를 response로 전달한다. 
	@PostMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		//중복된 경우: {"is_duplicate":true}
		//중복 안된 경우: {"is_duplicate":false}
		
//		if(favoriteBO.getisDulplicateUrl(url))
//		{
//			//중복된 것
//			resultMap.put("is_duplicate", true);
//		}
//		else {
//			//중복 안된 것
//			resultMap.put("is_duplicate", false);
//		}
		
		resultMap.put("is_duplicate", favoriteBO.getisDulplicateUrl(url));
		
		return resultMap;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, Boolean> delete(@RequestParam("id") int id) {
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		resultMap.put("deleted", favoriteBO.getDelete(id));
		
		return resultMap;
	}
}
