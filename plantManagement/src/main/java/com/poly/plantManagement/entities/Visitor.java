package com.poly.plantManagement.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
public class Visitor extends Users{
	@OneToOne(cascade = CascadeType.ALL)
    private Address address;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "visitor")
	@JsonIgnore
	private List<Bill> bills;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "visitor")
    @JsonIgnore
	private List<Comment> comment;
    
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	
}
