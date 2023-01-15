package com.poly.plantManagement.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.poly.plantManagement.entities.Photos;


public interface IServicePhotos {
		void savePhotos(Photos photo, MultipartFile mainPhoto,MultipartFile[] extraImages) throws IOException;
		Photos getPhoto(int id);
		Photos getPhotosByPlant(Integer id);
	    void deletePhoto(Integer id) throws IOException;
	    String saveImage(MultipartFile mf)throws IOException ;
	    public byte[] getPhotos(int id) throws IOException;
	    public byte[] getPhotos2(int id) throws IOException;
	    public byte[] getPhotos3(int id) throws IOException;
	    public byte[] getPhotos4(int id) throws IOException;
	    
}
