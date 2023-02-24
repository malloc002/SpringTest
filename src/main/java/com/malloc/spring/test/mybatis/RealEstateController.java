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
@RequestMapping("/mybatis")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	//전달받은 
	@ResponseBody
	@RequestMapping("/test01/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateBO.getRealEstate(id);
		
		return realEstate;
	}
	
	//전달받은 월세 금액보다 낮은 매물 정보를 json으로 response 담기
	@ResponseBody
	@RequestMapping("/test01/2")
	public List<RealEstate> rentPrice(@RequestParam("rp") int rp) {
		
		List<RealEstate> rentPriceList = realEstateBO.getRentPrice(rp);
		
		return rentPriceList;
		
	}
	
	@ResponseBody
	@RequestMapping("/test01/3")
	public List<RealEstate> areaPrice(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> areaPriceList = realEstateBO.getAreaPrice(area, price);
		
		return areaPriceList;
	}
	
	@ResponseBody
	@RequestMapping("/test02")
	public String addRealEstate(@RequestParam("realtorId") int realtorId) {
		 
//		RealEstate realEstate = new RealEstate();
//		realEstate.setRealtorId(3);
//		realEstate.setAddress("푸르지용 리버 303동 1104호");
//		realEstate.setArea(89);
//		realEstate.setType("매매");
//		realEstate.setPrice(100000);
//		
//		int count = realEstateBO.addRealEstateByObject(realEstate);
		
		//realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120
		int count = realEstateBO.addRealEstateByField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "실행결과: " + count;
		
	}
}
