package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.AdminNotFoundException;
import com.advices.ResourceNotFoundException;
import com.model.Admin;
import com.repository.AdminRepository;
import com.repository.AdminRepository;


@Service
public class AdminService {
	
	@Autowired
	AdminRepository repo;
	
	public Admin addAdmin(Admin c)
	{
		 repo.save(c);	
		 return c;
	}
	
	public List<Admin> getAdmins()
	{
		List<Admin> lc1=repo.findAll();
		
		return lc1;
	}

	public Admin getAdminById(int cid) throws Throwable {
		Supplier s1= ()->new AdminNotFoundException("Admin Does not exist in the database");
		Admin c=repo.findById(cid).orElseThrow(s1);
		return c;
	}

	public String deleteAdminById(int cid) {
		
		repo.deleteById(cid);
		
		return "Deleted";
	}

	public String deleteAdmin(Admin c) {
		
		repo.delete(c);
		return "Deleted";
	}

	public Admin updateAdmin(Admin c) throws Throwable {
		int id=c.getId();
		
		Supplier s1= ()->new AdminNotFoundException("Admin Does not exist in the database");
		Admin c1=repo.findById(id).orElseThrow(s1);
		
		c1.setAname(c.getAname());
		
			repo.save(c1);
			return c1;	
	}

	public List<Admin> addAdmins(List<Admin> ls) {
		repo.saveAll(ls);
		return ls;
	}
	
	

}

