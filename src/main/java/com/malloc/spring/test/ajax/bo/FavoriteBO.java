package com.malloc.spring.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malloc.spring.test.ajax.dao.FavoriteDAO;
import com.malloc.spring.test.ajax.model.Favorite;

@Service
public class FavoriteBO {
	
	@Autowired
	private FavoriteDAO favoriteDAO;

	public List<Favorite> getFavoriteList() {
		return favoriteDAO.selectFavoriteList();
	}
	
	public int getAddFavorite(String name, String url) {
		return favoriteDAO.insertFavorite(name, url);
	}
	
	public boolean getisDulplicateUrl(String url) {
		int count = favoriteDAO.selectCountUrl(url);
		
//		if(count == 0)
//		{
//			//중복안된 것
//			return false;
//		}
//		else {
//			//중복된 것
//			return true;
//		}
		
		return count != 0;
	}
	
	public boolean getDelete(int id) {
		int count = favoriteDAO.deleteFavorite(id);
		
		return count == 1;
	}
}
