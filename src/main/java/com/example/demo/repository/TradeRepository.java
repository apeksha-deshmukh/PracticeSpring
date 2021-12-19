package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TradeStoreModel;

@Repository
public interface TradeRepository extends JpaRepository<TradeStoreModel, String>{

}
