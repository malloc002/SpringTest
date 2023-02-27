package com.malloc.spring.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malloc.spring.test.jsp.dao.SellerDAO;
import com.malloc.spring.test.jsp.model.Seller;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;

	public int getAddSeller(String nickname, String profileImage, double temperature) {
		
		return sellerDAO.insertSeller(nickname, profileImage, temperature);
	}
	
	public Seller getLastSeller() {
		
		return sellerDAO.selectLastSeller();
	}
	
	public Seller getSellerById(int id) {
		
		return sellerDAO.selectSellerById(id);
	}
}
