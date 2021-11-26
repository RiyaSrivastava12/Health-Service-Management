package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="patient1")
public class Patient {

	// fields
	@Id
	@GeneratedValue
	private int Id;
	@NotBlank(message="Patient Name is required.")
	private String pName;	
	private int pAge;
	private long phoneNo;
	@NotBlank(message="Gender is required.")
	private String gender;
	@NotBlank(message="Address is required.")
	private String address;
	@NotBlank(message="Symptoms is required.")
	private String symptoms;

	
    //Getters & Setters
	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpAge() {
		return pAge;
	}

	public void setpAge(int pAge) {
		this.pAge = pAge;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms= symptoms;
	}
	

	@Override
	public String toString() {
		return "PatientPersonalDetails [pId=" + Id + ", pName=" + pName + ", pAge=" + pAge + ", phoneNo=" + phoneNo
				+ ", gender=" + gender + ", address=" + address + ", symptoms=" + symptoms + "]";
	}


	
	

}