package com.poly.plantManagement.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.poly.plantManagement.entities.Admin;

public interface IServiceAdmin {
    void saveAdmin(Admin admin,MultipartFile photo) throws IOException;
    List<Admin> getAllAdmins();
    Admin getAdmin(int id);
    List<Admin>  getAdminByName(String mc);
    void deleteAdmin(int id);
    void supprimerImage(Integer idVisitor) throws IOException;
    String saveImage(MultipartFile photo)throws IOException ;
    public byte[] getImage(int id) throws IOException;
}
