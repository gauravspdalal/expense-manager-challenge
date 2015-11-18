package com.alchtec.expensemanager.representations;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;
/**
 * Test to ensure that the JSON support works as expected.
 * @author dalalgau
 *
 */
public class ExpenseTest {
	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws Exception {
        final Expense expense = new Expense(new Date(0),new BigDecimal(120),"Expense reason",new BigDecimal(20));
        assertThat(MAPPER.writeValueAsString(expense))
                .isEqualTo(fixture("representations/expense.json"));
    }
    
    @Test
    public void deserializesFromJSON() throws Exception {
    	final Expense expense = new Expense(new Date(0),new BigDecimal(120),"Expense reason",new BigDecimal(20));
        assertThat(MAPPER.readValue(fixture("representations/expense.json"), Expense.class))
                .isEqualTo(expense);
    }
}