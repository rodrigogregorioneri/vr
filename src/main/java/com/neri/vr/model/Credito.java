package com.neri.vr.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "credit")
public class Credito {
	
	@Id
	private String id;
	
	@NotNull
	private Integer amount;
	

	private LocalDateTime createdAt;
	
	@NotNull
	private String createdBy;
	
	private LocalDateTime nextRecharge;

}
