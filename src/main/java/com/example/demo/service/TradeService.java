package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.LowerVersionNotAllowed;
import com.example.demo.model.TradeStoreModel;
import com.example.demo.repository.TradeRepository;

@Service
public class TradeService {

	@Autowired
	TradeRepository tradeRepository;

	public void addTrade(TradeStoreModel model) {
		// TODO Auto-generated method stub
		String tradeID = model.getTradeId();
		Integer versionFromDB =  tradeRepository.getById(tradeID).getVersion();
		if(model.getVersion() < versionFromDB)
			 throw new LowerVersionNotAllowed("Lower version not allowed..Thank you");
		else
			tradeRepository.save(model);
		
	}

	public List<TradeStoreModel> getTradeModels() {
		// TODO Auto-generated method stub
		return tradeRepository.findAll();
	}

	public TradeStoreModel getTradeByID(String tradeID) {
		// TODO Auto-generated method stub
		return tradeRepository.getById(tradeID);
	}

	
}
