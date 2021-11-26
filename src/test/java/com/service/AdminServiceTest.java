
package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Admin;
import com.repository.AdminRepository;



@SpringBootTest
class AdminServiceTest {
	
	@Autowired
	AdminService adminservice;
	
	@MockBean
	AdminRepository repo;

	@Test
	void testGetAdmins() {
		Admin c1=new Admin();
		c1.setId(1);
		c1.setAname("Riya");
		
		
		Admin c2=new Admin();
		c1.setId(2);
		c1.setAname("Aswin");
		
		
		List<Admin> doctorList = new ArrayList<>();
		doctorList.add(c1);
		doctorList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(doctorList);
		
		assertThat(adminservice.getAdmins()).isEqualTo(doctorList);
	}

	@Test
	//@Disabled
	void testGetAdminById() throws Throwable {
		
		  Admin c1=new Admin(); 
		  c1.setId(1);
		  c1.setAname("Riya");
			
		 
		
		Optional<Admin> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(adminservice.getAdminById(1)).isEqualTo(c1);
	}

	@Test
	void testAddAdmin() {
		Admin c1=new Admin();
		c1.setId(1);
		c1.setAname("Riya");
		
	Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(adminservice.addAdmin(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateAdmin() throws Throwable {
		Admin c1=new Admin();
		c1.setId(1);
		c1.setAname("Riya");
		
		Optional<Admin> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setAname("Summi");
		
		
		assertThat(adminservice.updateAdmin(c1)).isEqualTo(c1);
	}

	@Test
	void testDeleteAdmin() {
		Admin c1=new Admin();
		c1.setId(1);
		c1.setAname("Riya");
		
		Optional<Admin> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getId())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getId()));
	}

	/*
	 * @Test void testDeleteAdminById() { fail("Not yet implemented"); }
	 * 
	 * 
	 */

}