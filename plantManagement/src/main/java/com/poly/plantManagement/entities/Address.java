package com.poly.plantManagement.entities;


import javax.persistence.Entity;
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
public class Address {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idA ;
    private String num ;
    private String rue ;
	private String ville;
	private int codePostal;
	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private Visitor visitor;
	

	@Override
	public String toString() {
		return "Address [id=" + idA + ", num=" + num + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal
				+ "]";
	}
	public Integer getIdA() {
		return idA;
	}
	public void setIdA(Integer id) {
		this.idA = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	
}
