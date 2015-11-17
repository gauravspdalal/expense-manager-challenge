package com.alchtec.expensemanager.config;

import org.skife.jdbi.v2.DBI;

import com.alchtec.expensemanager.dao.ExpenseDAO;
import com.alchtec.expensemanager.resource.ExpenseManagerResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ExpenseManagerApplication extends Application<ExpenseManagerConfiguration>{
	
	public static void main(String[] args) throws Exception{
		new ExpenseManagerApplication().run(args);
	}
	
	@Override
	public void initialize(Bootstrap<ExpenseManagerConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/assets","/","default.html"));
	}

	@Override
	public void run(ExpenseManagerConfiguration configuration, Environment environment) throws Exception {
		final DBIFactory factory = new DBIFactory();
	    final DBI jdbi = factory.build(environment, configuration.getDsFactory(), "expense-database");
	    final ExpenseDAO dao = jdbi.onDemand(ExpenseDAO.class);
	    dao.createExpenseTable();
	    
	    final ExpenseManagerResource resource = new ExpenseManagerResource(dao);
		environment.jersey().register(resource);
	}

}
