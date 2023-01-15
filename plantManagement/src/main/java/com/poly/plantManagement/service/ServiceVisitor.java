package com.poly.plantManagement.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.plantManagement.dao.VisitorRepository;
import com.poly.plantManagement.entities.Visitor;

@Service
public class ServiceVisitor implements IServiceVisitor{

	private VisitorRepository vr;
	
	public ServiceVisitor(VisitorRepository vr) {
		super();
		this.vr = vr;
	}

	@Override
	public void saveVisitor(Visitor visitor,MultipartFile photo) throws IOException {
    	if(!photo.getOriginalFilename().equals("")) {
    		visitor.setPhoto(saveImage(photo));
    	}
		vr.save(visitor);
	}

	@Override
	public List<Visitor> getAllVisitor() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}

	@Override
	public Visitor getVisitor(int id) {
		// TODO Auto-generated method stub
		return vr.findById(id).get();
	}

	@Override
	public List<Visitor> getVisitorByName(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVisitor(int id) {
		// TODO Auto-generated method stub
		vr.deleteById(id);
	}

	@Override
	public void supprimerImage(Integer idVisitor) throws IOException {
		// TODO Auto-generated method stub
		Visitor visitor = vr.getById(idVisitor);
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path p = Paths.get(chemin,visitor.getPhoto());
		Files.delete(p);
	}

	@Override
	public String saveImage(MultipartFile photo) throws IOException {
		String nameFile = photo.getOriginalFilename();
		String tab[] =nameFile.split("\\.");
		String fileModif = tab[0]+"_"+System.currentTimeMillis()+"."+tab[1];
		
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path p = Paths.get(chemin,fileModif);
		Files.write(p,photo.getBytes());	
		
		return fileModif;
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		// TODO Auto-generated method stub
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages";
		Path path = Paths.get(chemin,getVisitor(id).getPhoto());
		return Files.readAllBytes(path);
	}

	@Override
	public Visitor login(String email, String password) {
		// TODO Auto-generated method stub
		return vr.findByEmailAndPassword(email, password);
	}


	

}
