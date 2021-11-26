package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Treatment;
import com.repository.TreatmentRepository;

@Service
public class TreatmentService {
	
	@Autowired
	TreatmentRepository repo;
	
	public Treatment addTreatment(Treatment t)
	{
		 repo.save(t);	
		 return t;
	}
	
	public List<Treatment> getTreatments()
	{
		List<Treatment> lt1=repo.findAll();
		
		return lt1;
	}

	public Treatment getTreatmentById(int cid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Treatment Does not exist in the database");
		Treatment c=repo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteTreatmentById(int tid) {
		
		repo.deleteById(tid);
		
		return "Deleted";
	}

	public String deleteTreatment(Treatment t) {
		
		repo.delete(t);
		return "Deleted";
	}

	public Treatment updateTreatment(Treatment t) throws Throwable {
		int id=t.getTid();
		
		Supplier s1= ()->new ResourceNotFoundException("Treatment Does not exist in the database");
		Treatment c1=repo.findById(id).orElseThrow(s1);
		
		c1.setTid(t.getTid());
		c1.setReports(t.getReports());
		c1.setMedicines(t.getMedicines());
		c1.setDescription(t.getDescription());
			repo.save(c1);
			return c1;	
	}

	public List<Treatment> addTreatments(List<Treatment> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	

}
