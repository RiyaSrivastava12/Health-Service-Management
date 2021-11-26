package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.model.Patient;
import com.service.PatientService;
import com.service.PatientService;

@RestController
@RequestMapping(path="/api")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("/getPatients")
	public ResponseEntity<List<Patient>> getPatients()
	{
		List<Patient> f1=patientService.getPatients();
		ResponseEntity re=new ResponseEntity<List<Patient>>(f1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient f){
		Patient f1=patientService.addPatient(f);
		ResponseEntity re = new ResponseEntity<Patient>(f,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addPatients")
	public ResponseEntity<List<Patient>> addPatients(@RequestBody List<Patient> fs)
	{
		List<Patient> fe=patientService.addPatients(fs);
		
		ResponseEntity re=new ResponseEntity<List<Patient>>(fe,HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getPatient/{bId}")
	public ResponseEntity<Patient> getPatient(@PathVariable int bId) throws Throwable{
		Patient f3=patientService.getPatientById(bId);
		ResponseEntity<Patient> re1=new ResponseEntity<Patient>(f3,HttpStatus.OK);
		return re1;
	}
	
	@DeleteMapping(path="/deletePatient/{bId}")
	public ResponseEntity<String> deletePatientById( @PathVariable int bId)
	{
		patientService.deletePatientById(bId);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted Patient with Patient No : "+bId,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deletePatients")
	public ResponseEntity<String> deletePatient(@RequestBody Patient f)
	{
		patientService.deletePatient(f);
		ResponseEntity re=new ResponseEntity<String>("Patient Deleted",HttpStatus.OK);
		return re;
	}  
	@PutMapping(path="/updatePatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient f) throws Throwable
	{
		Patient f1=patientService.updatePatient(f);
		ResponseEntity re=new ResponseEntity<Patient>(f1,HttpStatus.OK);
		return re;
	}

}
