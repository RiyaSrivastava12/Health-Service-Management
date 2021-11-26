package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor {

	//Fields
	@Id
	@GeneratedValue
	private int Id;
	
	@NotBlank(message="Name is required.")
	private String dname;
	
	@NotBlank(message="specialization is required.")
	private String specialization;
	
	@NotBlank(message="Qualification is required.")
	private String qualification;
	
	@NotBlank(message="Availability is required.")
	private String availability;
	
   
	//Getters and setters
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	@Override
	public String toString() {
		return "Doctor [dId=" + Id + ", dname=" + dname + ", specialization=" + specialization + ", qualification="
				+ qualification + ", availability=" + availability + "]";
	}
	
	
	
}
