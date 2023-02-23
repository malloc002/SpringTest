package com.malloc.spring.test.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.malloc.spring.test.database.model.Store;

@Repository
public interface StoreDAO {
	
	//Store 테이블 조회 리턴
	public List<Store> selectStoreList();
}
