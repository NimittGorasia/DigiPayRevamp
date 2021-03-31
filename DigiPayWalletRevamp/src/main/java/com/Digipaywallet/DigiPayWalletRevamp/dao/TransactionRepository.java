package com.Digipaywallet.DigiPayWalletRevamp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Digipaywallet.DigiPayWalletRevamp.entity.TransactionHistory;

public interface TransactionRepository extends CrudRepository<TransactionHistory, Long>{
	
	public List<TransactionHistory> findByUserId(Long userId);

}
