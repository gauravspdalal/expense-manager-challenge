package com.alchtec.expensemanager.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

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
