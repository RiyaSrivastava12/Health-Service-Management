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

import com.model.HealthInsurancePolicy;
import com.repository.HealthInsurancePolicyRepository;
import com.service.HealthInsurancePolicyService;

@SpringBootTest
class HealthInsurancePolicyTest {
	
	private static final Object HealthInsurancePolicy = null;

	@Autowired
	HealthInsurancePolicyService policyservice;
	
	@MockBean
	HealthInsurancePolicyRepository repo;

	@Test
	void testGetCoders() {
		HealthInsurancePolicy c1=new HealthInsurancePolicy();
		c1.setpNum(101);
		c1.setpName("raghu");
		
		c1.setpTerm(6);
		
		HealthInsurancePolicy c2=new HealthInsurancePolicy();
		c2.setpNum(101);
		c2.setpName("raghu");
		c2.setpTerm(6);
		
		List<HealthInsurancePolicy> policyserviceList = new ArrayList<>();
		policyserviceList.add(c1);
		policyserviceList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(policyserviceList);
		
		assertThat(policyservice.getHealthInsurancePolicys()).isEqualTo(policyserviceList);
	}

	//@Test
	@Disabled
	void testGetHealthInsurancePolicyBypNum() throws Throwable {
		HealthInsurancePolicy c1=new HealthInsurancePolicy();
		c1.setpNum(101);
		c1.setpName("raghu");
		c1.setpTerm(6);
		
		Optional<HealthInsurancePolicy> c2=Optional.empty();
		
		Mockito.when(repo.findById(101)).thenReturn(c2);
		
		assertThat(policyservice.getHealthInsurancePolicyById(101)).isEqualTo(c1);
	}

	@Test
	void testAddHealthInsurancePolicy() {
		HealthInsurancePolicy c1=new HealthInsurancePolicy();
		c1.setpNum(101);
		c1.setpName("raghu");
		c1.setpTerm(6);
	Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(policyservice.addHealthInsurancePolicy(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateHealthInsurancePolicy() throws Throwable {
		HealthInsurancePolicy c1=new HealthInsurancePolicy();
		c1.setpNum(101);
		c1.setpName("raghu");
		c1.setpTerm(6);
		Optional<HealthInsurancePolicy> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(101)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setpName("pavan");
		c1.setpTerm(6);
		
		assertThat(policyservice.updateHealthInsurancePolicy(c1)).isEqualTo(c1);
	}

	@Test
	void testDeleteHealthInsurancePolicy() {
		HealthInsurancePolicy c1=new HealthInsurancePolicy();
		c1.setpNum(101);
		c1.setpName("raghu");
		c1.setpTerm(6);
		Optional<HealthInsurancePolicy> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(101)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getpNum())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getpNum()));
	}

	
}