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
			, @RequestParam("temperature") String tString) {
		
		double temperature = Double.parseDouble(tString);
		
		int count = sellerBO.getAddSeller(nickname, profileImage, temperature);
		
		return "삽입성공: " + count;
	}
	
	@GetMapping("/input")
	public String sellerInput() {
		
		return "jsp/sellerInput";
	}
	
	@GetMapping("/seller_info")
	public String sellerInfo() {
		
		return "jsp/sellerInfo";
	}
	
	@GetMapping("/lastSeller")
	public String lastSeller(@RequestParam(value="id", required=false, defaultValue="-1") int id, Model model) {
		
		Seller seller;
		
		if(id == -1)
		{
			seller = sellerBO.getLastSeller();
		}
		else {
			seller = sellerBO.getSellerById(id);
		}
		
		model.addAttribute("seller", seller);
		
		return "jsp/sellerInfo";
	}
}
