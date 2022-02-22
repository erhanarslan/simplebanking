package com.eteration.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//This class is a place holder you can change the complete implementation

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "type", insertable = false, updatable = false)
	public String type;

	@Column(name = "approval_code")
	private String approvalCode;

	@NonNull
	@Column(name = "amount")
	public Double amount;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	public Transaction(Double transaction) {
		this.amount = transaction;
		this.date = new Date();
	}

	public Transaction(Date date, double amount, Account account, String approvalCode) {
		this.date = date;
		this.amount = amount;
		this.account = account;
		this.approvalCode = approvalCode;
	}

}
