package com.poly.plantManagement.restApiController;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.poly.plantManagement.entities.Address;
import com.poly.plantManagement.entities.Visitor;
import com.poly.plantManagement.service.ServiceAddress;
import com.poly.plantManagement.service.ServiceAdmin;
import com.poly.plantManagement.service.ServiceVisitor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/visitor")
public class VisitorControllerAPI {

	ServiceVisitor sv;
	ServiceAdmin sadmin;
	ServiceAddress sa;

	public VisitorControllerAPI(ServiceVisitor sv,ServiceAddress sa,ServiceAdmin sadmin) {
		super();
		this.sv = sv;
		this.sa=sa;
		this.sadmin=sadmin;
	}
	
	@GetMapping("/one/{id}")
	public Visitor getProduct(@PathVariable int  id){
		return  sv.getVisitor(id);
	}
	
	@GetMapping("/address/{id}")
	public Address getAdress(@PathVariable int  id){
		return  sa.getAddress(sv.getVisitor(id).getAddress().getIdA());
	}
	
	@GetMapping(path ="/getImageVistor/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageVistor(@PathVariable int  id) throws IOException
	{
		return sv.getImage(id);
	}
	
	@GetMapping(path ="/getImageAdmin/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageAdmin(@PathVariable int  id) throws IOException
	{
		return sadmin.getImage(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Integer> savePlant(@RequestParam("visitor") String p,@RequestParam("address") String a,@RequestParam("photo") MultipartFile photo) throws IOException {
		Address aa = new ObjectMapper().readValue(a,Address.class);
		Visitor pp = new ObjectMapper().readValue(p,Visitor.class);
		sa.saveAddress(aa);
		pp.setAddress(aa);
		sv.saveVisitor(pp,photo);
		return new ResponseEntity<>(
			      pp.getId(), 
			      HttpStatus.OK);
	}
		
	@PostMapping("/login")
	public Visitor login(@RequestParam("email") String email,@RequestParam("password") String password) throws IOException {
		return sv.login(email, password);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable int id) throws IOException{
			sv.deleteVisitor(id);
	}
	
	@PutMapping("update")
	public void update(@RequestParam("visitor") String p,@RequestParam("address") String a,@RequestParam("photo") MultipartFile photo ) throws IOException {
		Address aa = new ObjectMapper().readValue(a,Address.class);
		Visitor pp = new ObjectMapper().readValue(p,Visitor.class);
		sa.saveAddress(aa);
		if(aa.getIdA()!=null) {
			pp.setAddress(aa);			
		}
		sv.saveVisitor(pp,photo);
	}
}
