package com.controller;

import java.util.List;

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

import com.model.PatientHistory;
import com.service.PatientHistoryService;



@RestController
@RequestMapping(path="/api")
public class PatientHistoryController {
	
	@Autowired
	PatientHistoryService patienthistoryservice;
	
	
	@PostMapping("/addPatientHistory")
	public ResponseEntity<PatientHistory> addPatientHistory(@RequestBody PatientHistory d)
	{
		PatientHistory c1=patienthistoryservice.addPatientHistory(d);
		ResponseEntity re=new ResponseEntity<PatientHistory>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getAllPatientHistory")
	public ResponseEntity<List<PatientHistory>> getAllPatientHistory()
	{
		List<PatientHistory> lc1=patienthistoryservice.getAllPatientHistory();
		ResponseEntity re=new ResponseEntity<List<PatientHistory>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getPatientHistory/{did}")
	public ResponseEntity<PatientHistory> getEmpById(@PathVariable int did) throws Throwable
	{
		PatientHistory c1=patienthistoryservice.getPatientHistoryById(did);
		
		ResponseEntity re=new ResponseEntity<PatientHistory>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addAllPatientHistory")
	public ResponseEntity<List<PatientHistory>> addAllPatientHistory(@RequestBody List<PatientHistory> ls)
	{
		List<PatientHistory> le=patienthistoryservice.addAllPatientHistory(ls);
		
		ResponseEntity re=new ResponseEntity<List<PatientHistory>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updatePatientHistory")
	public ResponseEntity<PatientHistory> updatePatientHistory(@RequestBody PatientHistory e) throws Throwable
	{
		PatientHistory e1=patienthistoryservice.updatePatientHistory(e);
		
		ResponseEntity re=new ResponseEntity<PatientHistory>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deletePatientHistory")
	public ResponseEntity<String> deletePatientHistory(@RequestBody PatientHistory e)
	{
		patienthistoryservice.deletePatientHistory(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deletePatientHistory/{phid}")
	public ResponseEntity<String> deletePatientHistoryById(@PathVariable int phid)
	{
		patienthistoryservice.deletePatientHistoryById(phid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	

}
