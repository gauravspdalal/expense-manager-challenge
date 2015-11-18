package integrationtest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.client.Client;

import org.junit.ClassRule;
import org.junit.Test;

import com.alchtec.expensemanager.ExpenseManagerApplication;
import com.alchtec.expensemanager.config.ExpenseManagerConfiguration;

import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

/**
 * Built an integration test to check availability of the application
 * @author dalalgau
 *
 */
public class ExpenseManagerIntegrationTest {

	  @ClassRule
	    public static final DropwizardAppRule<ExpenseManagerConfiguration> RULE =
	            new DropwizardAppRule<ExpenseManagerConfiguration>(ExpenseManagerApplication.class, ResourceHelpers.resourceFilePath("expense-manager-configuration.yml"));

	    @Test
	    public void applicationAvailableOnInvocation() {
	        Client client = new JerseyClientBuilder(RULE.getEnvironment()).build("expense manager application test");

	        javax.ws.rs.core.Response response = client.target(
	                 String.format("http://localhost:%d/", RULE.getLocalPort()))
	                .request()
	                .get();

	        assertThat(response.getStatus()).isEqualTo(200);
	    }

}
