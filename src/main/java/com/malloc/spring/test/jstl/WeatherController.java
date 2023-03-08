package com.malloc.spring.test.jstl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.malloc.spring.test.jstl.bo.WeatherBO;
import com.malloc.spring.test.jstl.model.Weather;

@Controller
@RequestMapping("/jstl")
public class WeatherController {

	@Autowired
	private WeatherBO weatherBO; 
	
	@GetMapping("/test05")
	public String test05(Model model) {
		
		List<Weather> weatherHistory = weatherBO.getWeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "jstl/test05/weatherHistory";
	}
	
	@GetMapping("/input")
	public String input() {
		return "jstl/test05/weatherInput";
	}
	
	@ResponseBody
	@GetMapping("/add")
	public String addWeather(
			@RequestParam("date") Date date
			, @RequestParam("weather") String weather
			, @RequestParam("temperatures") double temperatures
			, @RequestParam("precipitation") double precipitation
			, @RequestParam("microDust") String microDust
			, @RequestParam("windSpeed") double windSpeed) {
		
		Weather weatherAdd = new Weather();
		weatherAdd.setDate(date);
		weatherAdd.setWeather(weather);
		weatherAdd.setTemperatures(temperatures);
		weatherAdd.setPrecipitation(precipitation);
		weatherAdd.setMicroDust(microDust);
		weatherAdd.setWindSpeed(windSpeed);
		
		int count = weatherBO.getAddWeather(weatherAdd);
		
//		return "삽입 결과:" + count;
		
		return "redirect:/jstl/test05/weatherHistory";
		
	}
	
}
