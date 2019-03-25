package com.neri.vr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neri.vr.controller.dto.Media;
import com.neri.vr.controller.dto.Total;
import com.neri.vr.model.Credito;
import com.neri.vr.service.CreditoService;

@RestController
@RequestMapping("/v1/creditos")
public class CreditoController {

	@Autowired
	private CreditoService creditoService;
	
	@GetMapping
	public List<Credito> list() {
		return creditoService.findAll();
	}
	
	@GetMapping("/total")
	public Total getTotal() {
		return creditoService.getTotal();
	}
	
	@GetMapping("/media")
	public Media getMedia() {
		return creditoService.getMedia();
	}
	
	@GetMapping("/{createdBy}")
	public List<Credito> getMedia(@PathVariable String createdBy) {
		return creditoService.findByCreatedBy(createdBy);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Credito create(@Validated @RequestBody Credito credito) {
		return creditoService.create(credito);
	}
	
}
