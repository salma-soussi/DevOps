package com.poly.plantManagement.restApiController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.plantManagement.entities.Category;
import com.poly.plantManagement.service.ServiceCategory;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/category")
public class CategoryControllerAPI {

	ServiceCategory sc;

	public CategoryControllerAPI(ServiceCategory sc) {
		super();
		this.sc = sc;
	}
	
	
	@GetMapping("/all")
	public List<Category> getAllCategories(){
		return  sc.getAllCategories();
	}
}
