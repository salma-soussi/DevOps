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

import com.poly.plantManagement.entities.Address;
import com.poly.plantManagement.entities.Visitor;
import com.poly.plantManagement.service.ServiceAddress;
import com.poly.plantManagement.service.ServiceVisitor;

@Controller
@RequestMapping("/app/user")
public class VisitorController {

	ServiceVisitor sv;
	ServiceAddress sa;

	public VisitorController(ServiceVisitor sv,ServiceAddress sa) {
		super();
		this.sv = sv;
		this.sa = sa;
	}
	
	@GetMapping("/all")
	public String getAllVisitors(Model m) {
		List<Visitor> list = sv.getAllVisitor();
		m.addAttribute("list",list);
		return "pages/user/usersList";
	}
	@GetMapping("/add")
	public String addVisitor(Model m) {
		return "pages/user/addUser";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Visitor visitor,@ModelAttribute Address address,@RequestParam("photo1") MultipartFile image,Model m) throws IOException {
		Integer id =visitor.getId();
		sa.saveAddress(address);
		visitor.setAddress(address);
		sv.saveVisitor(visitor,image);
		if(id!=null) {
			return "redirect:/app/user/all";
		}else {
			return "redirect:/app/user/all";
		}
		
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws IOException {
		sv.deleteVisitor(id);
		return "redirect:/app/user/all";
	}
	@GetMapping("/edit/{id}")
	public String edit  (Model m,@PathVariable("id") int id) {
		m.addAttribute("user",sv.getVisitor(id));
		m.addAttribute("address",sa.getAddress(id));
		return "pages/user/addUser";
	}
}
