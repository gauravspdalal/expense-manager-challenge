package com.alchtec.expensemanager.dao;

import java.sql.SQLException;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.alchtec.expensemanager.representations.Expense;
import com.google.common.collect.ImmutableList;

/**
 * The Data Access Object layer to provide abstraction with respect to low level database interactions.
 * This class uses the SQL Objects API of dropwizard jdbi module to help tag pure sql queries directly with
 * java methods. Helping the developer avoid verbose mapping code helping in both development and maintenance of this layer.
 * 
 *  A Mapper class is provided to aid the mapping of the Database result set vs java representation class.
 *  
 * @author dalalgau
 *
 */
@RegisterMapper(ExpenseMapper.class)
public interface ExpenseDAO {

	@SqlUpdate("create table if not exists Expense (id MEDIUMINT not null auto_increment,expense_date date not null,amount NUMERIC not null,reason VARCHAR(240),vat_amount NUMERIC,primary key(ID))")
	public void createExpenseSchemaTable() throws SQLException;
	
	@SqlUpdate("insert into Expense (expense_date,amount,reason,vat_amount) values (:date,:amount,:reason,:vatAmount)")
	public Integer saveExpense(@BindBean Expense person) throws SQLException;
	
	@SqlQuery("select * from Expense")
	public ImmutableList<Expense> retrieveExpenses() throws SQLException;
}

