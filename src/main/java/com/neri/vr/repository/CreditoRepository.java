package com.neri.vr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neri.vr.model.Credito;

public interface CreditoRepository extends MongoRepository<Credito, String> {

}
