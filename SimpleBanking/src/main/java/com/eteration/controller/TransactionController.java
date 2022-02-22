package com.eteration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.services.TransactionManager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@RestController
@RequestMapping("/transaction/v1/")
@AllArgsConstructor
public class TransactionController {

	private final TransactionManager transactionManager;
}
