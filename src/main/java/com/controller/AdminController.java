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

import com.model.Admin;
import com.service.AdminService;

@RestController
@RequestMapping(path="/api")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin d)
	{
		Admin c1=adminservice.addAdmin(d);
		ResponseEntity re=new ResponseEntity<Admin>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getAdmins")
	public ResponseEntity<List<Admin>> getAdmins()
	{
		List<Admin> lc1=adminservice.getAdmins();
		ResponseEntity re=new ResponseEntity<List<Admin>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getAdmin/{did}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int did) throws Throwable
	{
		Admin c1=adminservice.getAdminById(did);
		
		ResponseEntity re=new ResponseEntity<Admin>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addAdmins")
	public ResponseEntity<List<Admin>> addAdmins(@RequestBody List<Admin> ls)
	{
		List<Admin> le=adminservice.addAdmins(ls);
		
		ResponseEntity re=new ResponseEntity<List<Admin>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateAdmin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin e) throws Throwable
	{
		Admin e1=adminservice.updateAdmin(e);
		
		ResponseEntity re=new ResponseEntity<Admin>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteAdmin")
	public ResponseEntity<String> deleteAdmin(@RequestBody Admin e)
	{
		adminservice.deleteAdmin(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteAdmin/{eid}")
	public ResponseEntity<String> deleteAdminById(@PathVariable int eid)
	{
		adminservice.deleteAdminById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	

}
