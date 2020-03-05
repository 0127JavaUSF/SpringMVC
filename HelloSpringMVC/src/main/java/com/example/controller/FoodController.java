package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	//GetMapping, PutMapping
	@PostMapping(value="/getFoodById.app", produces="application/json", params= {"id"})
	public ResponseEntity<Food> getFoodById(int id){
		return new ResponseEntity<Food>(foodDao.selectById(id), HttpStatus.OK);
	}
	
	@PostMapping(value="{num}/getFoodByUri.app")
	public Food getFoodByUri(@PathVariable("num") int num) {
		return foodDao.selectById(num);
	}
}
