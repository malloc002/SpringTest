package com.malloc.spring.test.ajax.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.malloc.spring.test.ajax.model.Favorite;

@Repository
public interface FavoriteDAO {
	
	public List<Favorite> selectFavoriteList();
}
