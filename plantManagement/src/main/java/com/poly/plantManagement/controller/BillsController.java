package com.poly.plantManagement.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.plantManagement.entities.Bill;
import com.poly.plantManagement.service.ServiceBill;

@Controller
@RequestMapping("/app/bill")
public class BillsController {
	ServiceBill sb;

	public BillsController(ServiceBill sb) {
		super();
		this.sb = sb;
	}
	
	@GetMapping("/all")
	public String getAllBills(Model m) {
		List<Bill> list = sb.getAllBills();
		m.addAttribute("list",list);
		return "pages/bill/billsList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBill(@PathVariable int id) throws IOException {
		sb.deleteBill(id);
		return "redirect:/app/bill/all";
	}	
	
	@GetMapping("/edit/{id}")
	public String edit(Model m,@PathVariable("id") int id) {
		m.addAttribute("plant",sb.getBill(id));
		return "pages/bill/addBill";
	}
}
