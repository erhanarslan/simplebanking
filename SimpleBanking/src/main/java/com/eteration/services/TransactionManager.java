package com.eteration.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eteration.model.DepositTransaction;
import com.eteration.model.Transaction;
import com.eteration.repository.TransactionRepository;


@Service
public class TransactionManager {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }
	
	public void createTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}
	
}
