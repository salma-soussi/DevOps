package com.poly.plantManagement.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.plantManagement.entities.Category;
import com.poly.plantManagement.service.ServiceCategory;

@Controller
@RequestMapping("/app/category")
public class CategoryController {
	ServiceCategory sc;

	public CategoryController(ServiceCategory sc) {
		super();
		this.sc = sc;
	}
	
	@GetMapping("/all")
	public String getAllCategories(Model m) {
		List<Category> list = sc.getAllCategories();
		m.addAttribute("list",list);
		return "pages/category/categoriesList";
	}
	
	@GetMapping("/add")
	public String addPlant(Model m) {
		m.addAttribute("categories",sc.getAllCategories());
		return "pages/category/addCategory";
	}

	@PostMapping("/save")
	public String saveCategory(@ModelAttribute Category c,Model m) throws IOException {
		
		Integer id =c.getId();
		sc.saveCategory(c);
		if(id!=null) {
			return "redirect:/app/category/all";
		}else {
			m.addAttribute("message","Ajout avec succes");
			m.addAttribute("catagories",sc.getAllCategories());
			return "pages/category/addCategory";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable int id) throws IOException {
		sc.deleteCategory(id);
		return "redirect:/app/category/all";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model m,@PathVariable("id") int id) {
		m.addAttribute("plant",sc.getCategory(id));
		return "pages/category/addCategory";
	}
}
