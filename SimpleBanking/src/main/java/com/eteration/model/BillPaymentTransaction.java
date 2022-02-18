package com.eteration.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@DiscriminatorValue("BillPaymentTransaction")
public class BillPaymentTransaction extends WithdrawalTransaction {
	
	
	public String payee;

    public BillPaymentTransaction()
    {
        super();
    }

    public BillPaymentTransaction(double amount) {
        super(amount);
    }
    
   
	
	
	

}
