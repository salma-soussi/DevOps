package com.poly.plantManagement.service;

import java.util.List;


import com.poly.plantManagement.entities.Plant;

public interface IServicePlant {
    void savePlant(Plant plant);
    List<Plant> getAllPlants();
    Plant getPlant(int id);
    List<Plant>  getPlantByName(String mc);
    void deletePlant(int id);
}
