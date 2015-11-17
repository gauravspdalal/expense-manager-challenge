package com.alchtec.expensemanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.alchtec.expensemanager.representations.Expense;

/**
 * 
 * @author dalalgau
 *
 */
public class ExpenseMapper implements ResultSetMapper<Expense>{
	public Expense map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
		return new Expense(rs.getDate("EXPENSE_DATE"), rs.getBigDecimal("AMOUNT"), rs.getString("REASON"), rs.getBigDecimal("VAT_AMOUNT"));
	}
}
