package com.poly.plantManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.plantManagement.dao.CategoryRepository;
import com.poly.plantManagement.entities.Category;

@Service
public class ServiceCategory implements IServiceCategory{

	private CategoryRepository cr;
	
	public ServiceCategory(CategoryRepository cr) {
		super();
		this.cr = cr;
	}

	@Override
	public void saveCategory(Category category) {
		cr.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return cr.findAll();
	}

	@Override
	public Category getCategory(int id) {
		return cr.findById(id).get();
	}

	@Override
	public List<Category> getCategoryByName(String mc) {
		return null;
	}

	@Override
	public void deleteCategory(int id) {
		cr.deleteById(id);
	}

}
