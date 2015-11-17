package com.alchtec.expensemanager.representations;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Entity model class to represent the expense details state.
 * 
 * @author dalalgau
 *
 */
public class Expense {
	
	private Integer id;
	@NotNull
	private Date date;
	
	@NotNull
	private BigDecimal amount;
	
	@NotNull
	private String reason;
	private BigDecimal vatAmount;

	public Expense(Date date, BigDecimal amount, String reason, BigDecimal vatAmount) {
		this.date = date;
		this.amount = amount;
		this.reason = reason;
		this.vatAmount = vatAmount;
	}

	public Expense() {

	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Expense expense = (Expense) o;

		if (date != null ? !date.equals(expense.date) : expense.date != null)
			return false;
		if (id != null ? !id.equals(expense.id) : expense.id != null)
			return false;
		if (amount != null ? !amount.equals(expense.amount) : expense.amount != null)
			return false;
		if (reason != null ? !reason.equals(expense.reason) : expense.reason != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (date != null ? date.hashCode() : 0);
		result = 31 * result + (amount != null ? amount.hashCode() : 0);
		result = 31 * result + (reason != null ? reason.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return "Expense: date:"+this.date+"\nAmount:"+this.amount+"\nReason:"+this.reason+"\nVAT Amount:"+this.vatAmount;
	}

}
