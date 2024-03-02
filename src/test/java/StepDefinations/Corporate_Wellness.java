package StepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CorporateWellness;

public class Corporate_Wellness{
	WebDriver driver;
	 Logger logger;
	Properties p;
	CorporateWellness co;

	@Given("user is on Corporate Wellness Page")
	public void user_is_on_corporate_wellness_page() throws InterruptedException {
		driver=Hooks.getDriver();
		   logger=Hooks.getLogger();
		   p=Hooks.getProperties();
	   co=new CorporateWellness(driver);
	   co.Click_CorporateWellness();
	   logger.info("CorporateWellness is clicked");
	   
	}

	@When("user enters invalid detail")
	public void user_enters_invalid_detail() throws IOException {
		co.Enter_DetailsInvalid();
		logger.info("details entered");
	    
	}

	@When("user selects organizationsize and interest")
	public void user_selects_organizationsize_and_interest() {
		co.organization_size_and_Interest();
		logger.info("orgniztion size is selected");
	    
	}

	@When("clicks on submit button")
	public void clicks_on_submit_button() throws InterruptedException, IOException {
		 co.Click_Button();
		  
		  logger.info("submit button is clicked");
	   
	}

	@Then("user enters valid detail")
	public void user_enters_valid_detail() throws InterruptedException, IOException {
		co.clearDetail();
		co.Enter_DetailsValid();
		co.organization_size_and_Interest();
 		logger.info("orgniztion size is selected");
	    
	}

	@Then("clicks on submit button again")
	public void clicks_on_submit_button_again() throws InterruptedException, IOException {
		co.Click_Button();
	   	  
	   		logger.info("submit button is clicked");

	    }
	



}
