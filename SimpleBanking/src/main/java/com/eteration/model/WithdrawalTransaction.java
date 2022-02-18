package com.eteration.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//This class is a place holder you can change the complete implementation
@Entity
@DiscriminatorValue("WithdrawalTransaction")
public class WithdrawalTransaction extends Transaction {
	public WithdrawalTransaction() {
        super();
    }

    public WithdrawalTransaction(Double withdrawalTransaction) {
        super(withdrawalTransaction);
        this.setType("WithdrawalTransaction");
    }

	@Override
	protected void add(Transaction transaction) {
	
		
	}
    

}
