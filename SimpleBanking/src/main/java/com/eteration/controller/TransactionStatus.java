package com.eteration.controller;

import lombok.Getter;
import lombok.Setter;

//This class is a place holder you can change the complete implementation

@Getter
@Setter
public class TransactionStatus {
	
		public final static String status = "OK";

	    public String approvalCode;

	    public String getStatus() {
	        return status;
	    }
}
