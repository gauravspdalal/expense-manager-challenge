package com.alchtec.expensemanager.representations;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

/**
 * Representation class to represent the expense details state.
 * 
 * @author dalalgau
 *
 */
public class Expense {

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

		return Objects.equals(this.date, expense.date) && Objects.equals(this.amount, expense.amount)
				&& Objects.equals(this.reason, expense.reason);
	}

	@Override
	public int hashCode() {
		int result = date != null ? date.hashCode() : 0;
		result = 31 * result + (amount != null ? amount.hashCode() : 0);
		result = 31 * result + (reason != null ? reason.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("date", date).add("amount", amount).add("reason", reason)
				.add("vatAmount", vatAmount).toString();
	}

}
