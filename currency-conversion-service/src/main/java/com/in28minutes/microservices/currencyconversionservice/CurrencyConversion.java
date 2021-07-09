package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {

	private Long Id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private String environment;
	
	public CurrencyConversion() {}
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, String environment) {
		super();
		Id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}
	public Long getId() {
		return Id;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setId(Long id) {
		Id = id;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
}
