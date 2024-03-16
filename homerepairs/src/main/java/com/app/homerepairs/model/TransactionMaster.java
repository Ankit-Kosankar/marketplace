package com.app.homerepairs.model;

import java.math.BigDecimal;

import jakarta.persistence.ManyToOne;

public class TransactionMaster 
{
	private Long id;
	
	private String transactionId;
	
	private BigDecimal transactionAmount;
	
	private String transactionType;
	
	private String additionalData;
	
}
