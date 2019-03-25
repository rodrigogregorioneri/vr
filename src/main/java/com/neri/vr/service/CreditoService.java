package com.neri.vr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neri.vr.model.Credito;
import com.neri.vr.repository.CreditoRepository;

@Service
public class CreditoService {
	
	@Autowired
	private CreditoRepository repository;
	
	public Credito create(Credito credito) {
		return repository.save(credito);
	}
	
	public List<Credito> findAll() {
		return repository.findAll();
	}
	
	

}