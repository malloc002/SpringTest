package com.malloc.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.malloc.spring.test.jsp.bo.SellerBO;
import com.malloc.spring.test.jsp.model.Seller;

@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerBO sellerBO;

	@ResponseBody
	@PostMapping("/insert")
	public String addSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {

		
		int count = sellerBO.getAddSeller(nickname, profileImage, temperature);
		
		return "삽입성공: " + count;
	}
	
	@GetMapping("/input")
	public String sellerInput() {
		
		return "jsp/sellerInput";
	}
	
	@GetMapping("/sellerInfo")
	public String sellerInfo(@RequestParam(value="id", required=false, defaultValue="-1") int id, Model model) {
		
		//int 에는 null을 저장 못하는데 Integer에는 null 저장 가능
		
		Seller seller;
		
		//id 파라미터가 없으면 최근 판매자 결과 보여주기
		if(id == -1)
		{
			seller = sellerBO.getLastSeller();
		}
		else { //id 파라미터가 있으면 id로 조회한 결과 보여주기
			seller = sellerBO.getSellerById(id);
		}
		
		model.addAttribute("seller", seller);
		
		return "jsp/sellerInfo";
	}
}
