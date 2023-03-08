package com.malloc.spring.test.jstl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.malloc.spring.test.jstl.model.Weather;

@Repository
public interface WeatherDAO {

	public List<Weather> selectWeatherHistory();
	
	public int insertWeather(Weather weatherAdd);
}
