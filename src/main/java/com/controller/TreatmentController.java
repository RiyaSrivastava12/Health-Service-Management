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

import com.model.Treatment;
import com.service.TreatmentService;
import com.service.TreatmentService;

@RestController
@RequestMapping(path="/api")
public class TreatmentController {
	
	@Autowired
	TreatmentService treatmentservice;
	
	
	@PostMapping("/addTreatment")
	public ResponseEntity<Treatment> addTreatment(@RequestBody Treatment c)
	{
		Treatment c1=treatmentservice.addTreatment(c);
		ResponseEntity re=new ResponseEntity<Treatment>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getTreatments")
	public ResponseEntity<List<Treatment>> getTreatments()
	{
		List<Treatment> lc1=treatmentservice.getTreatments();
		ResponseEntity re=new ResponseEntity<List<Treatment>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getTreatment/{cid}")
	public ResponseEntity<Treatment> getEmpById(@PathVariable int cid) throws Throwable
	{
		Treatment c1=treatmentservice.getTreatmentById(cid);
		
		ResponseEntity re=new ResponseEntity<Treatment>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addTreatments")
	public ResponseEntity<List<Treatment>> addTreatments(@RequestBody List<Treatment> ls)
	{
		List<Treatment> le=treatmentservice.addTreatments(ls);
		
		ResponseEntity re=new ResponseEntity<List<Treatment>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateTreatment")
	public ResponseEntity<Treatment> updateTreatment(@RequestBody Treatment e) throws Throwable
	{
		Treatment e1=treatmentservice.updateTreatment(e);
		
		ResponseEntity re=new ResponseEntity<Treatment>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteTreatment")
	public ResponseEntity<String> deleteTreatment(@RequestBody Treatment e)
	{
		treatmentservice.deleteTreatment(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteTreatment/{eid}")
	public ResponseEntity<String> deleteTreatmentById(@PathVariable int eid)
	{
		treatmentservice.deleteTreatmentById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	

}
