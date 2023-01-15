package com.poly.plantManagement.restApiController;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.plantManagement.entities.Comment;
import com.poly.plantManagement.service.ServiceComment;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/comment")
public class CommentControllerAPI {

	ServiceComment sc;

	public CommentControllerAPI(ServiceComment sc) {
		super();
		this.sc = sc;
	}
	
	@GetMapping("/all")
	public List<Comment> getAllComment(){
		return  sc.getAllComments();
	}
	
	@GetMapping("/allByPlant/{id}")
	public List<Comment> getAllCommentByPlant(@PathVariable int  id){
		return  sc.getAllCommentsByPlant(id);
	}
	
	@GetMapping("/one/{id}")
	public Comment getProduct(@PathVariable int  id){
		return  sc.getComment(id);
	}
		
	@PostMapping("/add")
	public void savePlant(@RequestParam("comment") String p) throws IOException {
		Comment pp = new ObjectMapper().readValue(p,Comment.class);
		sc.saveComment(pp);
		
		
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable int id) throws IOException{
			sc.deleteComment(id);
	}
	
	@PutMapping("update")
	public void update( @RequestParam("comment") String p ) throws IOException {
		Comment pp = new ObjectMapper().readValue(p,Comment.class);
		sc.saveComment(pp);
	}
}
