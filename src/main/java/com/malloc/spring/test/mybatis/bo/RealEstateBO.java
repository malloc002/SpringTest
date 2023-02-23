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
	
	public RealEstate getRealEstate(int id) {
		
		RealEstate realEstate = realEstateDAO.selectRealEstate(id);
		
		return realEstate;
	}
	
	public List<RealEstate> getRentPrice(int rp) {
		
		List<RealEstate> rentPriceList = realEstateDAO.selectRentPrice(rp);
		
		return rentPriceList;
		
	}
	
	public List<RealEstate> getAreaPrice(int area, int price) {
		
		List<RealEstate> areaPriceList = realEstateDAO.selectAreaPrice(area, price);
		
		return areaPriceList;
	}
}
