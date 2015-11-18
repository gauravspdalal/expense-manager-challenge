package com.alchtec.expensemanager;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alchtec.expensemanager.config.ExpenseManagerConfiguration;
import com.alchtec.expensemanager.dao.ExpenseDAO;
import com.alchtec.expensemanager.resource.ExpenseManagerResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
/**
 * This class forms the core of the module.
 * It accesses the Configuration and combines the necessary bundles required to start the application.
 * 
 * @author dalalgau
 *
 */
public class ExpenseManagerApplication extends Application<ExpenseManagerConfiguration>{
	public static final Logger log = LoggerFactory.getLogger(ExpenseManagerApplication.class);
	
	public static void main(String[] args) throws Exception{
		new ExpenseManagerApplication().run(args);
	}
	
	/**
	 * This initialize method was used to add the Assets bundle pointing to 
	 * the assets folder with main/resources. 
	 */
	@Override
	public void initialize(Bootstrap<ExpenseManagerConfiguration> bootstrap) {
		log.debug("Initialize application");
		bootstrap.addBundle(new AssetsBundle("/assets","/","default.html"));
	}

	/**
	 * The run method uses the Configuration and Environment references to:
	 * i. Build a DBIFactory 
	 * ii. Run the necessary DB pre-requisites
	 * iii. Build the Resource class and register the same.
	 */
	@Override
	public void run(ExpenseManagerConfiguration configuration, Environment environment) throws Exception {
		log.debug("Run application");
		final DBIFactory factory = new DBIFactory();
	    final DBI jdbi = factory.build(environment, configuration.getDsFactory(), "expense-database");
	    final ExpenseDAO dao = jdbi.onDemand(ExpenseDAO.class);
	    
	    /*Create the underlying table/s required by the application*/
	    dao.createDatabaseSchema();
	    dao.createExpenseSchemaTable();
	    
	    final ExpenseManagerResource resource = new ExpenseManagerResource(dao);
		environment.jersey().register(resource);
	}

}
