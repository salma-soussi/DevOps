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

import com.poly.plantManagement.entities.Admin;
import com.poly.plantManagement.service.ServiceAdmin;

@Controller
@RequestMapping("/app/admin")
public class AdminController {

	ServiceAdmin sa;

	public AdminController(ServiceAdmin sa) {
		super();
		this.sa = sa;
	}
	
	@GetMapping("/all")
	public String getAllComments(Model m) {
		List<Admin> list = sa.getAllAdmins();
		m.addAttribute("list",list);
		return "pages/admin/adminList";
	}
	
	@GetMapping("/add")
	public String addComment(Model m) {
		return "pages/admin/addAdmin";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws IOException {
		sa.deleteAdmin(id);
		return "redirect:/app/admin/all";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Admin admin,@RequestParam("photo1") MultipartFile image,Model m) throws IOException {
		System.out.println("here");
		sa.saveAdmin(admin,image);
		return "redirect:/app/admin/all";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model m,@PathVariable("id") int id) {
		m.addAttribute("user",sa.getAdmin(id));
		return "pages/admin/addAdmin";
	}
}
