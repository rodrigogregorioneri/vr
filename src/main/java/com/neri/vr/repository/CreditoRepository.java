package com.neri.vr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neri.vr.model.Credito;

public interface CreditoRepository extends MongoRepository<Credito, String> {

	List<Credito> findByCreatedBy(String createdBy);
}
