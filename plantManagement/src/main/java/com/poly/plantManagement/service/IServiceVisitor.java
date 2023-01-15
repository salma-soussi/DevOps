package com.poly.plantManagement.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.poly.plantManagement.entities.Visitor;

public interface IServiceVisitor {
    void saveVisitor(Visitor visitor,MultipartFile photo) throws IOException;
    List<Visitor> getAllVisitor();
    Visitor getVisitor(int id);
    Visitor login(String email, String password);
    List<Visitor>  getVisitorByName(String mc);
    void deleteVisitor(int id);
    void supprimerImage(Integer idVisitor) throws IOException;
    String saveImage(MultipartFile photo)throws IOException ;
    public byte[] getImage(int id) throws IOException;
}
