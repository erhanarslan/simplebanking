package com.eteration.controller;

import org.springframework.http.HttpHeaders;

import java.util.Optional;
import java.util.UUID;



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
import com.eteration.model.BillPaymentTransaction;
import com.eteration.model.DepositTransaction;
import com.eteration.model.InsufficientBalanceException;
import com.eteration.model.Transaction;
import com.eteration.model.WithdrawalTransaction;
import com.eteration.services.AccountManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// This class is a place holder you can change the complete implementation

@RestController
@RequestMapping(value="/account/v1")
public class AccountController {
	
	@Autowired
	private AccountManager accountManager;
	//TODO://interfaceler ile encapsulation yapılacak

	//getbyid
	@GetMapping(value= "/{accountNumber}")
	public ResponseEntity<Account> getAccount(@PathVariable("accountNumber") String accountNumber) throws JsonProcessingException{
		Account account = accountManager.findAccount(accountNumber);
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("Content-Type", "application/json");
		ObjectMapper mapper= new ObjectMapper();
		mapper.writeValueAsString(account);
		
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	//debit
	@PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable("accountNumber") String accountNumber,
                                                   @RequestBody WithdrawalTransaction transaction)
            throws InsufficientBalanceException {

        Account account = accountManager.findAccount(accountNumber);

        if (Optional.ofNullable(account).isPresent()) {

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json;");

            String approvalCode = UUID.randomUUID().toString();

            WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction(transaction.getAmount());
            transaction.setType("WithdrawalTransaction");
            transaction.setDate(withdrawalTransaction.getDate());
            transaction.setApprovalCode(approvalCode);
            account.post(transaction);

            accountManager.saveAccount(account);

            TransactionStatus transactionStatus = new TransactionStatus();
            transactionStatus.setApprovalCode(approvalCode);

            return new ResponseEntity<TransactionStatus>(transactionStatus, headers, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
	//credit
	@PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable("accountNumber") String accountNumber,
                                                    @RequestBody DepositTransaction transaction)
            throws InsufficientBalanceException {

        Account account = accountManager.findAccount(accountNumber);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;");

        String approvalCode = UUID.randomUUID().toString();

        DepositTransaction depositTransaction = new DepositTransaction(transaction.getAmount());

        transaction.setAmount(transaction.getAmount());
        transaction.setType("DepositTransaction");
        transaction.setDate(depositTransaction.getDate());
        transaction.setApprovalCode(approvalCode);
        account.post(transaction);

        accountManager.saveAccount(account);
        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setApprovalCode(approvalCode);

        return new ResponseEntity<TransactionStatus>(transactionStatus, headers, HttpStatus.OK);
    }
	//payee yazılacak

	
	@PostMapping
	public void saveAccount(@RequestBody Account account) {
		accountManager.saveAccount(account);
	}
	
	
	
}
