package com.malloc.spring.test.jsp.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.malloc.spring.test.jsp.model.Seller;

@Repository
public interface SellerDAO {

	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("profileImage") String profileImage
			, @Param("temperature") double temperature);
	
	public Seller selectLastSeller();
	
	public Seller selectSellerById(@Param("id") int id);
	
}
