package com.poly.plantManagement.service;

import java.util.List;

import com.poly.plantManagement.entities.Comment;

public interface IServiceComment {
    void saveComment(Comment comment);
    List<Comment> getAllComments();
    List<Comment> getAllCommentsByPlant(int id);
    Comment getComment(int id);
    void deleteComment(int id);
}
