package com.malloc.spring.test.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.malloc.spring.test.ajax.bo.FavoriteBO;

@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteBO favoriteBO;
	
	@GetMapping("/ajax/list")
	public String FavoriteList(Model model) {
		
		return "ajax/list";
	}
}
