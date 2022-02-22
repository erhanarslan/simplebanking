package com.eteration.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//This class is a place holder you can change the complete implementation

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id", unique = true)
	private String accountId;

	@NonNull
	@Column(name = "owner")
	private String owner;

	@NonNull
	@Column(name = "account_number")
	private String accountNumber;

	@NonNull
	@Column(name = "balance")
	private Double balance;

	@Column(name = "creation_date")
	private Date creationDate = new Date();

	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<>();

	public Account(String owner, String accountNumber) {
		this.owner = owner;
		this.accountNumber = accountNumber;
	}

	public void post(Transaction transaction) throws InsufficientBalanceException {
		if ("DepositTransaction".equals(transaction.getType())) {
			this.balance +=transaction.amount;
			transactions.add(transaction);
		}

		if ("WithdrawalTransaction".equals(transaction.getType())) {
			if(this.balance <transaction.amount) {
				throw new InsufficientBalanceException();
				
			}else {
				this.balance -=transaction.amount;
				transactions.add(transaction);
			}
			
		}

	}

	public double deposit(double amount) {
		this.balance += amount;
		return amount;
	}

	public double withdraw(double amount) throws InsufficientBalanceException {

		if (this.balance < amount) {

			throw new InsufficientBalanceException();
		} else
			this.balance -= amount;
		return amount;

	}

	//public void payPhoneBill(double amount) throws InsufficientBalanceException {
	//	withdraw(amount);
	//}

}
