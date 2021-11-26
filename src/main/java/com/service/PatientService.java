package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Patient;
import com.repository.PatientRepository;


@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepo;
	
	public Patient addPatient(Patient f) {
		patientRepo.save(f);
		return f;
	}
	
	
	public List<Patient> addPatients(List<Patient> f) {
		patientRepo.saveAll(f);
		return f;
	}
	
	
	public List<Patient> getPatients() {
		List<Patient> bills = patientRepo.findAll();
		return bills;
	}
	
	
	public Patient getPatientById(int bId) throws Throwable {
		Supplier s1 = () -> new ResourceNotFoundException("Patient  : " + bId + " does not exist");
		Patient f1 = patientRepo.findById(bId).orElseThrow(s1);
		return f1;
	}
	
	
	public String deletePatientById(int bId) {
		patientRepo.deleteById(bId);
		return "Patient Deleted!!!";
	}
	
	
	public String deletePatient(Patient f) {
		patientRepo.delete(f);
		return "Deleted";
	}
	
	
	public Patient updatePatient(Patient f) throws Throwable {
		int id=f.getId();
		Supplier s1= ()->new ResourceNotFoundException("Patient Does not exist in the database");
		Patient f2=patientRepo.findById(id).orElseThrow(s1);
		f2.setpName(f.getpName());
		f2.setpAge(f.getpAge());
		f2.setPhoneNo(f.getPhoneNo());
	    f2.setGender(f.getGender());
		f2.setAddress(f.getAddress());
		f2.setSymptoms(f.getSymptoms());
		patientRepo.save(f2);
		return f2;
	}

}
