package com.eteration.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

//This class is a place holder you can change the complete implementation

@Entity

public class DepositTransaction extends Transaction {
	public DepositTransaction() {
        super();
    }

    public DepositTransaction(Double depositTransaction) {
        super(depositTransaction);
        this.setType("DepositTransaction");
    }


	

}
