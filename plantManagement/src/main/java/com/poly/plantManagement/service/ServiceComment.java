package com.poly.plantManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.plantManagement.dao.CommentRepository;
import com.poly.plantManagement.entities.Comment;

@Service
public class ServiceComment implements IServiceComment{

	private CommentRepository cr;
	
	public ServiceComment(CommentRepository cr) {
		super();
		this.cr = cr;
	}

	@Override
	public void saveComment(Comment comment) {
		cr.save(comment);
	}

	@Override
	public List<Comment> getAllComments() {
		return cr.findAll();
	}

	@Override
	public Comment getComment(int id) {
		return cr.findById(id).get();
	}

	@Override
	public void deleteComment(int id) {
		cr.deleteById(id);
	}

	@Override
	public List<Comment> getAllCommentsByPlant(int id) {
		// TODO Auto-generated method stub
		return cr.findAllByPlant_id(id);
	}

}
