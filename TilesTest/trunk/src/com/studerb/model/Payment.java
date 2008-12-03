package com.studerb.model;

// Generated Nov 26, 2008 10:41:24 AM by Hibernate Tools 3.2.2.GA

import java.math.BigDecimal;

import org.joda.time.DateTime;

/**
 * Payment generated by hbm2java
 */
public class Payment extends BaseEntity {

	public final static BigDecimal MAX_AMOUNT = new BigDecimal("99999.99");
	private static final long serialVersionUID = 1L;
	private Staff staff;
	private Customer customer;
	private Rental rental;
	private BigDecimal amount;
	private DateTime paymentDate;

	public Payment() {}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public DateTime getPaymentDate() {
		return this.paymentDate;
	}

	public Rental getRental() {
		return this.rental;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPaymentDate(DateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}
