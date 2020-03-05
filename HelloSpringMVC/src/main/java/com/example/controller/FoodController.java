package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Food;
import com.example.repository.FoodDao;

/*
 * @Controller - signifies that the class is a controller bean
 * @ResponseBody - specifies the returned value of the method will
 * constitute the body of the HTTP response.
 * 
 * @Controller + @ResponseBody = @RestController
 * 
 */
@RestController
public class FoodController {
	
	@Autowired
	private FoodDao foodDao;
	
	public FoodController() {
	}
	/*
	 * @RequestMapping - tells the HandlerMapping the controller
	 * method to go to based on the URI of the HTTP request passed to it
	 * by Dispatcher Servlet.
	 * Attributes you can set:
	 * value -> indicates the URI to which the handle method is mapped
	 * method -> defines the type of HTTP request it is intended
	 * to handle (GET, POST, PUT, DELETE, etc)
	 * 
	 * google.com/donuts -> URL
	 * "/donuts" -> URI
	 */
	
	@RequestMapping(value="/getAllFood.app", method=RequestMethod.GET)
	public List<Food> getAllFood(){
		return foodDao.selectAll();
	}

}
