package com.eteration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eteration.controller.TransactionStatus;
import com.eteration.model.Account;
import com.eteration.model.AccountNotFoundException;
import com.eteration.model.InsufficientBalanceException;
import com.eteration.repository.AccountRepository;

import lombok.NonNull;


@Service
public class AccountManager{
	
	private AccountRepository accountRepository;
	
	public Account saveAccount(final Account account) {
        return accountRepository.save(account);
    }
	
	public List<Account> getAll() {
        return this.accountRepository.findAll();
    }
	
	public Account findByAccountNumber(String accountNumber)
	{
		return this.accountRepository.findByAccountNumber(accountNumber);
	}

	
	
	
}
