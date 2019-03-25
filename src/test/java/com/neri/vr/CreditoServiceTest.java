package com.neri.vr;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neri.vr.model.Credito;
import com.neri.vr.service.CreditoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditoServiceTest {
	
	@Autowired
	private CreditoService creditoService;
	
	@Test
	public void createCreditTest() {
		Credito credito = new Credito();
		credito.setAmount(1);
		credito.setCreatedAt(LocalDateTime.now());
		credito.setCreatedBy("teste");
		credito.setNextRecharge(LocalDateTime.now());
		Credito result = creditoService.create(credito);
	}

}
