package com.poly.plantManagement.entities;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@ToString
public class Photos {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	
	@OneToOne(mappedBy = "photos",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Plant plant;
	
	public Photos(Integer id, String photo1, String photo2, String photo3, String photo4) {
		super();
		this.id = id;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
	}

	public Photos(Integer id, String photo1, String photo2, String photo3) {
		super();
		this.id = id;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
	}

	public Photos(Integer id, String photo1, String photo2) {
		super();
		this.id = id;
		this.photo1 = photo1;
		this.photo2 = photo2;
	}

	public Photos(Integer id, String photo1) {
		super();
		this.id = id;
		this.photo1 = photo1;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public String getPhoto4() {
		return photo4;
	}

	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	
}
