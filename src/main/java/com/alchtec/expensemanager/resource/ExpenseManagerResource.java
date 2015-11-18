package com.alchtec.expensemanager.resource;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alchtec.expensemanager.dao.ExpenseDAO;
import com.alchtec.expensemanager.representations.Expense;
import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableList;

/**
 * This is the Resource class to serve user requests.
 * This class will expose a REST API to the client and regulate requests to the database.
 * @author dalalgau
 *
 */
@Path("/expenses")
public class ExpenseManagerResource {
	public static final Logger log = LoggerFactory.getLogger(ExpenseManagerResource.class);
	private final ExpenseDAO expenseDAO;
	
	public ExpenseManagerResource(ExpenseDAO expenseDAO) {
		this.expenseDAO =  expenseDAO;
	}

	/**
	 * A POST method invocation to save the Expense added by the user on the front-end.
	 * @param expense
	 * @throws Exception
	 */
	@POST
	@Timed
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveExpenseEntry(@Valid Expense expense) throws WebApplicationException {
		if(expense != null){
			log.debug("Saving expense ->"+expense);
			try {
				expenseDAO.saveExpense(expense);	
			} catch (Exception e) {
				log.error("Exception occurred while saving expense: " +e.getMessage());
				throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
	/**
	 * A GET method invocation to retrieve all the expense entries saved by the user.
	 * @return
	 * @throws Exception
	 */
	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	public ImmutableList<Expense> retrieveExpenseDetails() throws WebApplicationException {
		log.debug("Retrieve all added expense entries");
		try {
			return expenseDAO.retrieveExpenses();	
		} catch (Exception e) {
			log.error("Exception occurred while retrieving expenses: " +e.getMessage());
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
