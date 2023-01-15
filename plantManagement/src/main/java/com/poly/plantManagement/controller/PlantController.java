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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.plantManagement.entities.Photos;
import com.poly.plantManagement.entities.Plant;
import com.poly.plantManagement.service.ServiceCategory;
import com.poly.plantManagement.service.ServicePhotos;
import com.poly.plantManagement.service.ServicePlant;
@Controller
@RequestMapping("/app/plant")
public class PlantController {
	ServicePlant sp;
	ServiceCategory sc;
	ServicePhotos sphoto;
	
	public PlantController(ServicePlant sp, ServiceCategory sc,ServicePhotos sphoto) {
		super();
		this.sp = sp;
		this.sc = sc;
		this.sphoto = sphoto;
	}
	@GetMapping("/all")
	public String getAllPlants(Model m) {
		List<Plant> list = sp.getAllPlants();
		m.addAttribute("list",list);
		return "pages/plants/plantsList";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePlant(@PathVariable int id) throws IOException {
		sp.deletePlant(id);
		return "redirect:/app/plant/all";
	}
	
	@GetMapping("/add")
	public String addPlant(Model m) {
		m.addAttribute("category",sc.getAllCategories());
		return "pages/plants/addPlant";
	}
	
	@GetMapping("/one/{id}")
	public String getPlant(@PathVariable int  id,Model m) throws IOException{
		  m.addAttribute("plant",sp.getPlant(id));
		  return "pages/plants/plant";
	}

	@PostMapping("/save")
	public String savePlant(@ModelAttribute Plant p,@ModelAttribute Photos photos,@RequestParam("mainPhoto") MultipartFile mainPhoto,@RequestParam("extraImages") MultipartFile[] extraImages,Model m) throws IOException {
		Integer id =p.getId();
		sphoto.savePhotos(photos, mainPhoto, extraImages);
		p.setPhotos(photos);
		sp.savePlant(p);
		
		if(id!=null) {
			return "redirect:/app/plant/all";
		}else {
			m.addAttribute("message","Ajout avec succes");
			m.addAttribute("catagories",sc.getAllCategories());
			return "redirect:/app/plant/all";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model m,@PathVariable("id") int id) {
		m.addAttribute("category",sc.getAllCategories());
		m.addAttribute("plant",sp.getPlant(id));
		return "pages/plants/addPlant";
	}

}
