package com.malloc.spring.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malloc.spring.test.jsp.dao.RealtorDAO;
import com.malloc.spring.test.jsp.model.Realtor;

@Service
public class RealtorBO {
	
	@Autowired
	private RealtorDAO realtorDAO;

	public int getAddRealtor(Realtor realtor) {
		
		return realtorDAO.insertRealtor(realtor);
	}
}
