package com.poly.plantManagement.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.plantManagement.dao.PhotosRepository;
import com.poly.plantManagement.entities.Photos;
import com.poly.plantManagement.entities.Plant;

@Service
public class ServicePhotos implements IServicePhotos {

	private PhotosRepository pr;
	
	public ServicePhotos(PhotosRepository pr) {
		super();
		this.pr = pr;
	}

	@Override
	public void savePhotos(Photos photo, MultipartFile mainfile ,MultipartFile[] extraImages) throws IOException {
		
		List<String> fileNames = new ArrayList<>();
		Arrays.asList(extraImages).stream().forEach(file -> {
            try {
        		if(!file.getOriginalFilename().equals("")) {
            		fileNames.add(saveImage(file));
            	}
            } catch (IOException e) {

            }
        });
		if(fileNames.size()>0) {
			if(fileNames.size()==1) {
				photo.setPhoto2(fileNames.get(0));
			}else if(fileNames.size()==2) {
				photo.setPhoto2(fileNames.get(0));
				photo.setPhoto3(fileNames.get(1));
			}else if(fileNames.size()==3) {
				photo.setPhoto2(fileNames.get(0));
				photo.setPhoto3(fileNames.get(1));
				photo.setPhoto4(fileNames.get(2));
			}
		}
		if(!mainfile.getOriginalFilename().equals("")) {
    		photo.setPhoto1(saveImage(mainfile));
    	}
		pr.save(photo);
	}

	@Override
	public void deletePhoto(Integer id) throws IOException {
		pr.deleteById(id);;
	}

	@Override
	public String saveImage(MultipartFile mf) throws IOException {
		String nameFile = mf.getOriginalFilename();
		String tab[] =nameFile.split("\\.");
		String fileModif = tab[0]+"_"+System.currentTimeMillis()+"."+tab[1];
		
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path p = Paths.get(chemin,fileModif);
		Files.write(p,mf.getBytes());	
		
		return fileModif;
	}

	@Override
	public byte[] getPhotos(int id) throws IOException {
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path path = Paths.get(chemin,getPhoto(id).getPhoto1());
		return Files.readAllBytes(path);
	}

	@Override
	public Photos getPhoto(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public byte[] getPhotos2(int id) throws IOException {
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path path = Paths.get(chemin,getPhoto(id).getPhoto2());
		return Files.readAllBytes(path);	}

	@Override
	public byte[] getPhotos3(int id) throws IOException {
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path path = Paths.get(chemin,getPhoto(id).getPhoto3());
		return Files.readAllBytes(path);
	}

	@Override
	public byte[] getPhotos4(int id) throws IOException {
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path path = Paths.get(chemin,getPhoto(id).getPhoto4());
		return Files.readAllBytes(path);
	}

	@Override
	public Photos getPhotosByPlant(Integer  id) {
		// TODO Auto-generated method stub
		return pr.findByPlant_id(id);
	}



}
