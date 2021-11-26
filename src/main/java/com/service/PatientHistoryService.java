package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.PatientHistory;
import com.repository.PatientHistoryRepository;



@Service
public class PatientHistoryService {
	
	@Autowired
	PatientHistoryRepository repo;
	
	public PatientHistory addPatientHistory(PatientHistory ph)
	{
		 repo.save(ph);	
		 return ph;
	}
	
	public List<PatientHistory> getAllPatientHistory()
	{
		List<PatientHistory> lc1=repo.findAll();
		
		return lc1;
	}

	public PatientHistory getPatientHistoryById(int phid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("PatientHistory Does not exist in the database");
		PatientHistory c=repo.findById(phid).orElseThrow(s1);
		return c;
	}

	public String deletePatientHistoryById(int phid) {
		
		repo.deleteById(phid);
		
		return "Deleted";
	}

	public String deletePatientHistory(PatientHistory ph) {
		
		repo.delete(ph);
		return "Deleted";
	}

	public PatientHistory updatePatientHistory(PatientHistory ph) throws Throwable {
		int id=ph.getId();
		
		Supplier s1= ()->new ResourceNotFoundException("PatientHistory Does not exist in the database");
		PatientHistory c1=repo.findById(id).orElseThrow(s1);
		
		c1.setDisease(ph.getDisease());
		c1.setdAdvice(ph.getdAdvice());
		c1.setDiet(ph.getDiet());
	//	c1.setTreatment(ph.getTreatment());
			repo.save(c1);
			return c1;	
	}

	public List<PatientHistory> addAllPatientHistory(List<PatientHistory> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	

}

