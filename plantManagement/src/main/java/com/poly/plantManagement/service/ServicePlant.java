package com.poly.plantManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.poly.plantManagement.dao.PlantRepository;
import com.poly.plantManagement.entities.Plant;

@Service
public class ServicePlant implements IServicePlant{
	private PlantRepository pr;

	public ServicePlant(PlantRepository pr) {
		super();
		this.pr = pr;
	}

	@Override
	public void savePlant(Plant plant){
		pr.save(plant);
	}

	@Override
	public List<Plant> getAllPlants() {
		return pr.findAll();
	}
	public List<Plant> getPlantsByCategory(int id) {
		return pr.findAllByCategories_id(id);
	}

	@Override
	public Plant getPlant(int id) {
		return pr.findById(id).get();
	}

	@Override
	public List<Plant> getPlantByName(String mc) {
		return null;
	}

	@Override
	public void deletePlant(int id) {
		pr.deleteById(id);
	}

}
