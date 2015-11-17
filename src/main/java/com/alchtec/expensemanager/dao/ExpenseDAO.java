package com.alchtec.expensemanager.dao;

import java.sql.SQLException;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.alchtec.expensemanager.representations.Expense;

@RegisterMapper(ExpenseMapper.class)
public interface ExpenseDAO {

	@SqlUpdate("create table if not exists Expense (id MEDIUMINT not null auto_increment,expense_date date not null,amount NUMERIC not null,reason VARCHAR(32),vat_amount NUMERIC,primary key(ID))")
	public void createExpenseTable() throws SQLException;
	
	@SqlUpdate("insert into Expense (expense_date,amount,reason,vat_amount) values (:date,:amount,:reason,:vatAmount)")
	public Integer saveExpense(@BindBean Expense person) throws SQLException;
	
	@SqlQuery("select * from Expense")
	public List<Expense> retrieveExpenses() throws SQLException;
}
