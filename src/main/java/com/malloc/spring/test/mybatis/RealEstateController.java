package com.malloc.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.malloc.spring.test.mybatis.bo.RealEstateBO;
import com.malloc.spring.test.mybatis.model.RealEstate;

@Controller
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	@ResponseBody
	@RequestMapping("/mybatis/test01/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateBO.getRealEstate(id);
		
		return realEstate;
	}
	
	@ResponseBody
	@RequestMapping("/mybatis/test01/2")
	public List<RealEstate> rentPrice(@RequestParam("rp") int rp) {
		
		List<RealEstate> rentPriceList = realEstateBO.getRentPrice(rp);
		
		return rentPriceList;
		
	}
	
	@ResponseBody
	@RequestMapping("/mybatis/test01/3")
	public List<RealEstate> areaPrice(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> areaPriceList = realEstateBO.getAreaPrice(area, price);
		
		return areaPriceList;
	}
}
