# Expense Manager Application

## Description

This module is responsible for the following:

i. Providing a UI to Add Expenses to the database.
ii. VAT Amount can be calculated on the fly. (Assuming that the Amount value entered is inclusive of 20% VAT).
iii. Maintain and Display a list of all expenses added by the user. 

## Build and Run the Application

I forked the existing repository and renamed it to expense-manager-challenge
The source code for the application has been uploaded to the following GIT repository.

https://github.com/gauravspdalal/expense-manager-challenge/

Before proceeding with installation, ensure that the pre-requisites are taken care of:

1. Maven 3 is installed.

2. JRE 8 is available.

Perform the below steps to build the application jar and run the same.

1. Download the source code from the Git Repository.

2. Using the Command Prompt window, navigate to the source code folder. (This should contain the pom.xml)

3. Build the application using the following maven command: 
	
		mvn clean install

4. An executable jar file will be created in the target folder.

5. Run the jar by navigating to the target and run the below command:

	java –jar <<jar_name>>.jar server <<configuration-file-name>>.yml

In our case it should be: 
	
	java -jar target/expense-manager-application-1.0.0.jar server expense-manager-configuration.yml

6. This will invoke the Dropwizard ExpenseManagerApplication, which will finally make application available to end user. 

    
## Accessing the application

The application can be accessed using the below URL:

	http://localhost:8080/
    

## Accessing the Application Health Check
Navigate to

    http://localhost:8080/admin

This will provide links to an operational menu. Click on Health Check link to view the Database Health-check data.

## Technologies used

1. The REST API has been developed using the dropwizard framework. Given the requirements of this activity, drop-wizard seemed like a quintessential fit. It comes bundled with modules (Jetty, Jersey, Jackson, Guava, Metrics) required to assist in building a REST API. The framework assists in seam-less integration of these modules.

2. The database access layer uses the SQL Objects API (further explanation in com.alchtec.expensemanager.dao.ExpenseDAO.java)

3. JUnit tests.

4. My SQL has been used as the database.