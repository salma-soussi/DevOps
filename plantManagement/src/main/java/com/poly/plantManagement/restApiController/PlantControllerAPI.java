package com.poly.plantManagement.restApiController;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.poly.plantManagement.entities.Photos;
import com.poly.plantManagement.entities.Plant;
import com.poly.plantManagement.service.ServicePhotos;
import com.poly.plantManagement.service.ServicePlant;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/plant")
public class PlantControllerAPI {

	ServicePlant sp;
	ServicePhotos sphoto;
	
	public PlantControllerAPI(ServicePlant sp,ServicePhotos sphoto) {
		super();
		this.sp = sp;
		this.sphoto = sphoto;
	}
	
	@GetMapping("/all")
	public List<Plant> getAllPlants(){
		return  sp.getAllPlants();
	}
	@GetMapping("/photo/{id}")
	public Photos getAllPhotos(@PathVariable int  id){
		return  sphoto.getPhotosByPlant(id);
	}
	
	
	@GetMapping("/one/{id}")
	public Plant getProduct(@PathVariable int  id){
		return  sp.getPlant(id);
	}
	@GetMapping("/category/{id}")
	public List<Plant> getProductByCategory(@PathVariable int  id){
		return  sp.getPlantsByCategory(id);
	}
	
	@GetMapping(path ="/getImage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable int  id) throws IOException
	{
		return sphoto.getPhotos(sp.getPlant(id).getPhotos().getId());
		
	}
	@GetMapping(path ="/getImage2/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage2(@PathVariable int  id) throws IOException
	{
		return sphoto.getPhotos2(sp.getPlant(id).getPhotos().getId());
		
	}
	@GetMapping(path ="/getImage3/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage3(@PathVariable int  id) throws IOException
	{
		return sphoto.getPhotos3(sp.getPlant(id).getPhotos().getId());
		
	}
	@GetMapping(path ="/getImage4/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage4(@PathVariable int  id) throws IOException
	{
		return sphoto.getPhotos4(sp.getPlant(id).getPhotos().getId());
		
	}
	
	@PostMapping("/add")
	public void savePlant(@RequestParam("plant") String p,@RequestParam("mainPhoto") MultipartFile mainPhoto,@RequestParam("extraImages") MultipartFile[] extraImages ) throws IOException {
		Plant pp = new ObjectMapper().readValue(p,Plant.class);
		if(mainPhoto!=null){
	   		Photos phs = new Photos();
			sphoto.savePhotos(phs, mainPhoto, extraImages);
			pp.setPhotos(phs);
	   	}
		sp.savePlant(pp);
		
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable int id) throws IOException{
			sp.deletePlant(id);
	}
	
	@PutMapping("update")
	public void update(@RequestParam("plant") String p,@RequestParam("mainPhoto") MultipartFile mainPhoto,@RequestParam("extraImages") MultipartFile[] extraImages ) throws IOException {
		Plant pp = new ObjectMapper().readValue(p,Plant.class);
				
	   	if(mainPhoto!=null){
	   		Photos phs = sphoto.getPhoto(pp.getPhotos().getId());
			sphoto.savePhotos(phs, mainPhoto, extraImages);
			pp.setPhotos(phs);
	   	}
		sp.savePlant(pp);
	}
}
