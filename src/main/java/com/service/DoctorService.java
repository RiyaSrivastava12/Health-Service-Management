package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.DoctorNotFoundException;
import com.advices.ResourceNotFoundException;
import com.model.Doctor;
import com.repository.DoctorRepository;


@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository repo;
	
	public Doctor addDoctor(Doctor c)
	{
		 repo.save(c);	
		 return c;
	}
	
	public List<Doctor> getDoctors()
	{
		List<Doctor> lc1=repo.findAll();
		
		return lc1;
	}

	public Doctor getDoctorById(int cid) throws Throwable {
		Supplier s1= ()->new DoctorNotFoundException("Doctor Does not exist in the database");
		Doctor c=repo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteDoctorById(int cid) {
		
		repo.deleteById(cid);
		
		return "Deleted";
	}

	public String deleteDoctor(Doctor c) {
		
		repo.delete(c);
		return "Deleted";
	}

	public Doctor updateDoctor(Doctor c) throws Throwable {
		int id=c.getId();
		
		Supplier s1= ()->new DoctorNotFoundException("Doctor Does not exist in the database");
		Doctor c1=repo.findById(id).orElseThrow(s1);
		
		c1.setDname(c.getDname());
		c1.setQualification(c.getQualification());
		c1.setSpecialization(c.getSpecialization());
		c1.setAvailability(c.getAvailability());
			repo.save(c1);
			return c1;	
	}

	public List<Doctor> addDoctors(List<Doctor> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	

}

