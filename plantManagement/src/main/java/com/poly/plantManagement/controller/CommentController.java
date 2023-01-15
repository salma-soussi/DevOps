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

import com.poly.plantManagement.entities.Admin;
import com.poly.plantManagement.entities.Comment;
import com.poly.plantManagement.entities.Plant;
import com.poly.plantManagement.service.ServiceAdmin;
import com.poly.plantManagement.service.ServiceComment;
import com.poly.plantManagement.service.ServicePlant;

@Controller
@RequestMapping("/app/comment")
public class CommentController {
	ServiceComment sc;
	ServiceAdmin sa;
	ServicePlant sp;

	public CommentController(ServiceComment sc,ServiceAdmin sa,ServicePlant sp) {
		super();
		this.sc = sc;
		this.sa = sa;
		this.sp = sp;
	}
	
	@GetMapping("/all")
	public String getAllComments(Model m) {
		List<Comment> list = sc.getAllComments();
		m.addAttribute("list",list);
		return "pages/comment/commentsList";
	}
	
	@GetMapping("/add")
	public String addComment(Model m) {
		List<Admin> listAdmin = sa.getAllAdmins();
		m.addAttribute("listAdmin",listAdmin);
		List<Plant> listPlant = sp.getAllPlants();
		m.addAttribute("listPlant",listPlant);
		return "pages/comment/addComment";
	}
	
	@PostMapping("/save")
	public String saveComment(@ModelAttribute Comment c,Model m) throws IOException {
		
		Integer id =c.getId();
		sc.saveComment(c);
		if(id!=null) {
			return "redirect:/app/comment/all";
		}else {
			m.addAttribute("message","Ajout avec succes");
			return "pages/comment/addComment";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteComment(@PathVariable int id) throws IOException {
		sc.deleteComment(id);
		return "redirect:/app/comment/all";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model m,@PathVariable("id") int id) {
		m.addAttribute("comment",sc.getComment(id));
		List<Admin> listAdmin = sa.getAllAdmins();
		m.addAttribute("listAdmin",listAdmin);
		List<Plant> listPlant = sp.getAllPlants();
		m.addAttribute("listPlant",listPlant);
		return "pages/comment/addComment";
	}
	
	
}
