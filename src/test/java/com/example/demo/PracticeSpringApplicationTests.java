package com.example.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.TradeStoreModel;
import com.example.demo.repository.TradeRepository;

@SpringBootTest
class PracticeSpringApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	
	@Autowired
	TradeRepository tradeRepository;
	
	@Test
	public void testAddTrade() {
		
		TradeStoreModel trade = new TradeStoreModel("T3",3,"CP-2","B2","2022-12-10");
		tradeRepository.save(trade);
		
		Assertions.assertTrue(tradeRepository.findAll().size()==1);
	}
}
