package com.alchtec.expensemanager.resource;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alchtec.expensemanager.dao.ExpenseDAO;
import com.alchtec.expensemanager.representations.Expense;
import com.codahale.metrics.annotation.Timed;

/**
 * Resource class to serve user requests.
 * @author dalalgau
 *
 */
@Path("/expenses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExpenseManagerResource {
	
	private final ExpenseDAO expenseDAO;
	
	public ExpenseManagerResource(ExpenseDAO expenseDAO) {
		this.expenseDAO =  expenseDAO;
	}

	@POST
	@Timed
	public void saveExpenseEntry(@Valid Expense expense) throws Exception{
		expenseDAO.saveExpense(expense);	
	}
	
	@GET
	@Timed
	public List<Expense> retrieveExpenseDetails() throws Exception{
		return expenseDAO.retrieveExpenses(); 
	}

}
