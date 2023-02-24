package com.malloc.spring.test.mybatis.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malloc.spring.test.mybatis.dao.RealEstateDAO;
import com.malloc.spring.test.mybatis.model.RealEstate;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateDAO realEstateDAO;
	
	//전달받은 id와 일치하는 데이터 조회 리턴
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstateDAO.selectRealEstate(id);
		
		return realEstate;
	}
	
	//전달받은 월세 금액보다 낮은 매물 정보들 리턴
	public List<RealEstate> getRentPrice(int rp) {
		
		List<RealEstate> rentPriceList = realEstateDAO.selectRentPrice(rp);
		
		return rentPriceList;
		
	}
	
	public List<RealEstate> getAreaPrice(int area, int price) {
		
		List<RealEstate> areaPriceList = realEstateDAO.selectAreaPrice(area, price);
		
		return areaPriceList;
	}
	
	public int addRealEstateByObject(RealEstate realEstate) {
		
		return realEstateDAO.insertRealEstate(realEstate);
	}
	
	public int addRealEstateByField(int realtorId, String address, int area, String type, int price, int rentPrice) {
		
		return realEstateDAO.insertRealEstateByField(realtorId, address, area, type, price, rentPrice);
	}
}
