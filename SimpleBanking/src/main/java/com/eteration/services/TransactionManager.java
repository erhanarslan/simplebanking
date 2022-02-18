package com.eteration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eteration.repository.TransactionRepository;


@Service
public class TransactionManager {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public TransactionManager(TransactionRepository transactionRepository) {
		this.transactionRepository=transactionRepository;
	}
	
	
}
