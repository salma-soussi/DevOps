package com.poly.plantManagement.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.plantManagement.dao.AdminRepository;
import com.poly.plantManagement.entities.Admin;

@Service
public class ServiceAdmin implements IServiceAdmin{

	private AdminRepository ar;
	
	public ServiceAdmin(AdminRepository ar) {
		super();
		this.ar = ar;
	}

	@Override
	public void saveAdmin(Admin admin,MultipartFile photo) throws IOException {
    	if(!photo.getOriginalFilename().equals("")) {
    		admin.setPhoto(saveImage(photo));
    		
    	}
    	
		ar.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public Admin getAdmin(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}

	@Override
	public List<Admin> getAdminByName(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		ar.deleteById(id);
	}

	@Override
	public void supprimerImage(Integer idAdmin) throws IOException {
		// TODO Auto-generated method stub
		Admin admin = ar.getById(idAdmin);
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path p = Paths.get(chemin,admin.getPhoto());
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
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/ProjectSpringImages/";
		Path path = Paths.get(chemin,getAdmin(id).getPhoto());
		return Files.readAllBytes(path);
	}




}
