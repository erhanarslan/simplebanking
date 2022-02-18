package com.eteration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//This class is a place holder you can change the complete implementation
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsufficientBalanceException extends Exception {
	
	private String message;

}
