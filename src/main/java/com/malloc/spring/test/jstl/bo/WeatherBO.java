package com.malloc.spring.test.jstl.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malloc.spring.test.jstl.dao.WeatherDAO;
import com.malloc.spring.test.jstl.model.Weather;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherDAO weatherDAO;

	public List<Weather> getWeatherHistory() {
		
		return weatherDAO.selectWeatherHistory();
	}
	
	public int getAddWeather(Weather weatherAdd) {
		return weatherDAO.insertWeather(weatherAdd);
	}
}
