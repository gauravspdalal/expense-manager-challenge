package com.alchtec.expensemanager.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
/**
 * This class represents the configuration state of the application derived from the expense-manager-configuration.yml
 * file.
 * The javax validations are used to define the validation conditions for the configuration parameters used to start-up the 
 * application. 
 * @author dalalgau
 *
 */
public class ExpenseManagerConfiguration extends Configuration{

	@Valid
	@NotNull
	private DataSourceFactory dsFactory = new DataSourceFactory();

	@JsonProperty("database")
	public DataSourceFactory getDsFactory() {
		return dsFactory;
	}

	@JsonProperty("database")
	public void setDsFactory(DataSourceFactory dsFactory) {
		this.dsFactory = dsFactory;
	}
	
}
