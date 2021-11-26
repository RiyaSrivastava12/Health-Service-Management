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

import com.model.Doctor;
import com.service.DoctorService;



@RestController
@RequestMapping(path="/api")
public class DoctorController {
	
	@Autowired
	DoctorService doctorservice;
	
	@PostMapping("/addDoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor d)
	{
		Doctor c1=doctorservice.addDoctor(d);
		ResponseEntity re=new ResponseEntity<Doctor>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getDoctors")
	public ResponseEntity<List<Doctor>> getDoctors()
	{
		List<Doctor> lc1=doctorservice.getDoctors();
		ResponseEntity re=new ResponseEntity<List<Doctor>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getDoctor/{did}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int did) throws Throwable
	{
		Doctor c1=doctorservice.getDoctorById(did);
		
		ResponseEntity re=new ResponseEntity<Doctor>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addDoctors")
	public ResponseEntity<List<Doctor>> addDoctors(@RequestBody List<Doctor> ls)
	{
		List<Doctor> le=doctorservice.addDoctors(ls);
		
		ResponseEntity re=new ResponseEntity<List<Doctor>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor e) throws Throwable
	{
		Doctor e1=doctorservice.updateDoctor(e);
		
		ResponseEntity re=new ResponseEntity<Doctor>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteDoctor")
	public ResponseEntity<String> deleteDoctor(@RequestBody Doctor e)
	{
		doctorservice.deleteDoctor(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteDoctor/{eid}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable int eid)
	{
		doctorservice.deleteDoctorById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	

}
