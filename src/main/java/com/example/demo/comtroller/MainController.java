package com.example.demo.comtroller;

import java.sql.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TradeStoreModel;
import com.example.demo.service.TradeService;



@RestController
@RequestMapping("api/tradeStore")
public class MainController {

	@Autowired
	TradeService tradeService;
	
	@GetMapping(value="/")
	public String helloMethod() {
		
		return "hello welcome ...";
	}
	
	@GetMapping("/getTrade")
	public ResponseEntity<List<TradeStoreModel>> getTradeModels()
	{
		
		return new ResponseEntity<List<TradeStoreModel>>(tradeService.getTradeModels(),HttpStatus.OK);
		
	}
	
	@GetMapping("/getTrade/{tradeid}")
	public ResponseEntity<TradeStoreModel> getTradeModelByTradeID(@PathVariable String tradeID)
	{
		return new ResponseEntity<TradeStoreModel>(tradeService.getTradeByID(tradeID),HttpStatus.OK);
		
	}
	
	@PostMapping("/addTrade")
	public TradeStoreModel addTrade(@RequestBody TradeStoreModel model) throws ParseException {
		//TradeStoreModel model = new TradeStoreModel("T1",2,"CP-2","B-3","2022-12-19");
		
		tradeService.addTrade(model);
		return model;
		
	}
	
	
}
