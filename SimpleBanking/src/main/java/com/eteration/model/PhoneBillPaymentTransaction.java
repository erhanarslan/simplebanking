package com.eteration.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@DiscriminatorValue("PhoneBillPaymentTransaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBillPaymentTransaction extends BillPaymentTransaction {
	
	@NonNull
	String phoneNumber;
	@NonNull
	String operatorName;
	
	 public PhoneBillPaymentTransaction(String operatorName, String phoneNumber, double transaction) {

	        super(transaction);
	        this.operatorName = operatorName;
	        this.phoneNumber = phoneNumber;
	        this.type = "WithdrawalTransaction";
	        this.amount = transaction;

	    }

}
