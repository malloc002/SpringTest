package com.malloc.spring.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.malloc.spring.test.mybatis.model.RealEstate;

@Repository
public interface RealEstateDAO {

	public RealEstate selectRealEstate(@Param("id") int id);
	
	public List<RealEstate> selectRentPrice(@Param("rp") int rp);
	
	public List<RealEstate> selectAreaPrice(@Param("area") int area, @Param("price") int price);
}
