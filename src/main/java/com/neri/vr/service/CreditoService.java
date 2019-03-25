package com.neri.vr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neri.vr.controller.dto.Media;
import com.neri.vr.controller.dto.Total;
import com.neri.vr.model.Credito;
import com.neri.vr.repository.CreditoRepository;

@Service
public class CreditoService {
	
	int total = 0;
	
	@Autowired
	private CreditoRepository repository;
	
	public Credito create(Credito credito) {
		return repository.save(credito);
	}
	
	public List<Credito> findAll() {
		return repository.findAll();
	}
	
	public Total getTotal(){
		List<Credito> credito =repository.findAll();
		credito.forEach(c ->{
			total += c.getAmount();
		});
		return new Total(total);
	}
	
	public Media getMedia(){
		List<Credito> credito =repository.findAll();
		credito.forEach(c ->{
			total += c.getAmount();
		});
		return new Media(total / credito.size());
	}
	
	public List<Credito> findByCreatedBy(String createdBy) {
		return repository.findByCreatedBy(createdBy);
	}
	
	

}
