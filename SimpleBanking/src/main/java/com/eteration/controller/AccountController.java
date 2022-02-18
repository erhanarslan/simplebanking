package com.eteration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.model.Account;
import com.eteration.model.AccountNotFoundException;
import com.eteration.model.InsufficientBalanceException;
import com.eteration.model.WithdrawalTransaction;
import com.eteration.services.AccountManager;

// This class is a place holder you can change the complete implementation

@RestController
@RequestMapping(value="/account/v1")
public class AccountController {
	
	@Autowired
	private AccountManager accountManager;
	//TODO://interfaceler ile encapsulation yapılacak

	@GetMapping(value= "/{accountNumber}")
	public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) throws AccountNotFoundException{
		Account account = accountManager.findByAccountNumber(accountNumber);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@PostMapping
	public void saveAccount(@RequestBody Account account) {
		accountManager.saveAccount(account);
	}
	
	//debit, credit, paybill, payee yazılacak
	
}
